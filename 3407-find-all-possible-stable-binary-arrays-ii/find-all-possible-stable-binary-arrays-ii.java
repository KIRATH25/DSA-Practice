import java.util.*;
class Solution {
  public int numberOfStableArrays(int zeros, int ones, int limit) {
    final int MOD = 1_000_000_007;
    // dp[i][j][0] → arrays using i zeros and j ones ending with 0
    // dp[i][j][1] → arrays using i zeros and j ones ending with 1
    long[][][] dp = new long[zeros + 1][ones + 1][2];
    for (int i = 0; i <= zeros && i <= limit; i++) {
      dp[i][0][0] = 1;
    }
    for (int j = 0; j <= ones && j <= limit; j++) {
      dp[0][j][1] = 1;
    }
    for (int i = 1; i <= zeros; i++) {
      for (int j = 1; j <= ones; j++) {
        long waysEndZero = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
        if (i - limit - 1 >= 0) {
          waysEndZero = (waysEndZero - dp[i - limit - 1][j][1] + MOD) % MOD;
        }
        dp[i][j][0] = waysEndZero;
        long waysEndOne = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
        if (j - limit - 1 >= 0) {
          waysEndOne = (waysEndOne - dp[i][j - limit - 1][0] + MOD) % MOD;
        }
        dp[i][j][1] = waysEndOne;
      }
    }
    return (int) ((dp[zeros][ones][0] + dp[zeros][ones][1]) % MOD);
  }
}