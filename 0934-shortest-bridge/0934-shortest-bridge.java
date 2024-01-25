class Solution {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> qu = new LinkedList<>();
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int n = grid.length, m = grid[0].length, ans = 0;
        boolean flag = false;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    DFS(grid, qu, i, j);
                    flag = true;
                    break;
                }
            }

            if (flag) break;
        }


        while (!qu.isEmpty()) {
            int size = qu.size();

            for (int i = 0; i < size; i++) {
                int[] current = qu.poll();

                for (int[] direction : directions) {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];

                    if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == -1) 
                        continue;
                    
                    if (grid[x][y] == 1) 
                        return ans;

                    grid[x][y] = -1;
                    qu.add(new int[] { x, y });
                }
            }

            ans++;
        }

        return -1;
    }

    public void DFS(int[][] grid, Queue<int[]> qu, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1 || grid[x][y] == 0) 
            return;
        
        grid[x][y] = -1;
        qu.add(new int[] { x, y });

        DFS(grid, qu, x - 1, y);
        DFS(grid, qu, x, y + 1);
        DFS(grid, qu, x + 1, y);
        DFS(grid, qu, x, y - 1);
        

        return;
    }
}