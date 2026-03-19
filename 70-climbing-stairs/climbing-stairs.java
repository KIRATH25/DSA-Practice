class Solution {
    public int climbStairs(int n) {
        int[] kirath = new int[n + 1];
        kirath[0] = 1;
        kirath[1] = 1;
        for (int i = 2; i <= n; ++i){
            kirath[i] = kirath[i - 1] + kirath[i - 2];
        }
        return kirath[n];
    }
}