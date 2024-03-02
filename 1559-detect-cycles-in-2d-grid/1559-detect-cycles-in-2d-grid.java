class Solution {
    int path = 0;

    public boolean containsCycle(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && dfs(grid, visited, i, j, i, j)) {
                    return true;
                }      
            }
        }

        return false;
    }

    public boolean dfs(char[][] grid, int[][] visited, int sx, int sy, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[sx][sy] != grid[x][y]) {
            return false;
        }

        if (visited[x][y] - visited[sx][sy] >= 3) {
            return true;
        }

        if (visited[x][y] != 0) {
            return false;
        }

        visited[x][y] = path++;

        return (
            dfs(grid, visited, x, y, x + 1, y) || 
            dfs(grid, visited, x, y, x - 1, y) || 
            dfs(grid, visited, x, y, x, y - 1) || 
            dfs(grid, visited, x, y, x, y + 1));
    }
}