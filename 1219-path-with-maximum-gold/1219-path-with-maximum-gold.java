class Solution {
    public int getMaximumGold(int[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 0;
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0)
                    ans = Math.max(ans, DFS(grid, vis, i, j));
            }
        }

        return ans;
    }

    private int DFS(int[][] grid, boolean[][] vis, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || vis[x][y])
            return 0;

        int gold = grid[x][y];
        vis[x][y] = true;

        int l = DFS(grid, vis, x - 1, y);
        int r = DFS(grid, vis, x + 1, y);
        int u = DFS(grid, vis, x, y - 1);
        int d = DFS(grid, vis, x, y + 1);

        vis[x][y] = false;

        return gold + Math.max(l, Math.max(r, Math.max(u, d)));
    }
}