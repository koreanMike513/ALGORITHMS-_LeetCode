class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length, lands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && grid[i][j] == 1) {
                    numEnclaves(grid, i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    lands++;
                }
            }
        }

        return lands;
    }

    public boolean numEnclaves(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
            return false;
        }

        grid[x][y] = -1; 

        boolean left = numEnclaves(grid, x, y - 1);
        boolean right = numEnclaves(grid, x, y + 1);
        boolean up = numEnclaves(grid, x - 1, y);
        boolean down = numEnclaves(grid, x + 1, y);

        return left && right && up && down;
    }
}