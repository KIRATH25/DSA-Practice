import java.util.*;

public class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        HashSet<Integer> prefixes = new HashSet<>();

        // Store prefixes of arr1
        for (int num : arr1) {
            while (num > 0) {
                prefixes.add(num);
                num /= 10;
            }
        }

        int ans = 0;

        // Check prefixes in arr2
        for (int num : arr2) {

            while (num > 0) {

                if (prefixes.contains(num)) {
                    ans = Math.max(ans, String.valueOf(num).length());
                }

                num /= 10;
            }
        }

        return ans;
    }
}