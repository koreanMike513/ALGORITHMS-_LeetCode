class Solution {
    public int uniquePathsIII(int[][] grid) {
        int zero = 0, sx = 0, sy = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    zero++;
                }

                else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }

        return uniquePaths(grid, sx, sy, zero);
    }

    public int uniquePaths(int[][] grid, int x, int y, int zero) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }

        if (grid[x][y] == 2) {
            return (zero == -1) ? 1 : 0;
        }

        grid[x][y] = -1;
        zero--;

        int path = (
            uniquePaths(grid, x - 1, y, zero) + 
            uniquePaths(grid, x, y - 1, zero) + 
            uniquePaths(grid, x + 1, y, zero) + 
            uniquePaths(grid, x, y + 1, zero)
        );

        grid[x][y] = 0;
        zero++;

        return path;
    }
}