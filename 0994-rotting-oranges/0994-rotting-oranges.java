class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> qu = new LinkedList<>();
        int n = grid.length, m = grid[0].length, total = 0, ans = 0;
        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    qu.add(new int[] { i, j });
                }

                else if (grid[i][j] == 1) {
                    total++;
                }
            }
        }

        if (total == 0) {
            return 0;
        }

        while (!qu.isEmpty()) {
            if (total == 0) {
                return ans;
            }

            int size = qu.size();
            ans++;

            for (int i = 0; i < size; i++) {
                int[] current = qu.poll();

                for (int[] direction : directions) {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];

                    if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != 1) {
                        continue;
                    }

                    if (grid[x][y] == 1) {
                        grid[x][y] = 2;
                        qu.add(new int[] { x, y });
                        total--;
                    }
                }
            }
        }

        return -1;
    }
}