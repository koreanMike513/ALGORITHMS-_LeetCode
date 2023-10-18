class Solution {
    private int ans = 0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;

        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid1[i][j] == 1 && grid1[i][j] == grid2[i][j]) {
                    ans = 1;
                    visited(grid1, grid2, i, j);
                    res += ans;
                }
            }
        }

        return res;
    }

    public void visited(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length || grid2[i][j]== 0) return;
        
        if (grid1[i][j] == 0) ans = 0;
        grid2[i][j] = 0;

        visited(grid1, grid2, i - 1, j);
        visited(grid1, grid2, i, j - 1);
        visited(grid1, grid2, i + 1, j);
        visited(grid1, grid2, i, j + 1);
    }
}