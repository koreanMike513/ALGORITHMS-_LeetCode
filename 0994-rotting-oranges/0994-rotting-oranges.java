class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> qu = new LinkedList<>();
        int[][] directions = new int[][]{ { 0, 1 }, { 0, - 1}, { 1, 0 }, { - 1, 0 } };
        int seconds = -1, n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int fresh = findRottenOrangesAndCountFreshOranges(grid, qu);

        if (fresh == 0)
            return 0;

        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                int[] current = qu.poll();

                for (int[] direction : directions) {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];

                    if (x < 0 || y < 0 || x >= n || y >= m || vis[x][y] || grid[x][y] != 1)
                        continue;
                    
                    qu.add(new int[]{ x, y });
                    fresh--;
                    vis[x][y] = true;
                }
            }

            seconds++;
        }

        return (fresh == 0) ? seconds : -1;
    }

    private int findRottenOrangesAndCountFreshOranges(int[][] grid, Queue<int[]> qu) {
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    qu.add(new int[]{ i, j });

                else if (grid[i][j] == 1)
                    fresh++;
            }
        }

        return fresh;
    }
}