class Solution {

    private boolean isIsland = true;

    public int closedIsland(int[][] grid) {
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    isIsland = true;
                    BFS(grid, i, j);
                    islands += (isIsland) ? 1 : 0;
                }
            }
        }

        return islands;
    }

    public void BFS(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row + 1 > grid.length || col + 1 > grid[0].length) {
            isIsland = false;

            return;
        }

        if (grid[row][col] == 1) {
            return;
        }

        grid[row][col] = 1;

        BFS(grid, row - 1, col);
        BFS(grid, row + 1, col);
        BFS(grid, row, col - 1);
        BFS(grid, row, col + 1);
    }
}