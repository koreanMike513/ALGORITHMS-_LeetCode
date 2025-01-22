class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length, max = 0;
        int[][] directions = new int[][]{ { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int[][] map = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> qu = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    map[i][j] = 0;
                    vis[i][j] = true;
                    qu.add(new int[]{ i, j, 0 });
                }
            }
        }

        while (!qu.isEmpty()) {
            int size = qu.size();

            for (int i = 0; i < size; i++) {
                int[] c = qu.poll();
                
                for (int[] direction : directions) {
                    int x = c[0] + direction[0];
                    int y = c[1] + direction[1];

                    if (x >= n || y >= m || x < 0 || y < 0 || vis[x][y]) {
                        continue;
                    }

                    vis[x][y] = true;
                    map[x][y] = c[2] + 1;
                    qu.add(new int[]{ x, y, c[2] + 1 });
                }
            }
        }

        return map;
    }
}