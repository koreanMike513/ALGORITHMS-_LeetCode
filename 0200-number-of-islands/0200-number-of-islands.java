class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    traverseIslands(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void traverseIslands(char[][] grid, int row, int col) {
        if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == '1') {
            grid[row][col] = '0';
            traverseIslands(grid, row + 1, col);
            traverseIslands(grid, row - 1, col);
            traverseIslands(grid, row, col + 1);
            traverseIslands(grid, row, col - 1);
        }

        else {
            return;
        }
    }
}