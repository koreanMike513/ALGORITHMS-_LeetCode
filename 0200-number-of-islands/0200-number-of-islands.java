class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    checkIslands(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void checkIslands(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0')
            return;
        
        grid[x][y] = '0';

        checkIslands(grid, x + 1, y);
        checkIslands(grid, x - 1, y);
        checkIslands(grid, x, y + 1);
        checkIslands(grid, x, y - 1);
    }
}