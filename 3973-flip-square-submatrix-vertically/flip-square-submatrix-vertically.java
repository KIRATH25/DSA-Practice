class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int half = k / 2;
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < k; j++) {
                int temp = grid[x + i][y + j];
                grid[x + i][y + j] = grid[x + k - 1 - i][y + j];
                grid[x + k - 1 - i][y + j] = temp;
            }
        }
        return grid;
    }
}