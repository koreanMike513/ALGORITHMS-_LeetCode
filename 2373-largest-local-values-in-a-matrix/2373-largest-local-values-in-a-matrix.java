class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                ans[i][j] = getLargestLocal(grid, i, j);
            }
        }

        return ans;
    }

    private int getLargestLocal(int[][] grid, int rs, int cs) {
        int largest = 0;

        for (int i = rs; i <= rs + 2; i++) {
            for (int j = cs; j <= cs + 2; j++) {
                largest = Math.max(largest, grid[i][j]);
            }
        }

        return largest;
    }
}