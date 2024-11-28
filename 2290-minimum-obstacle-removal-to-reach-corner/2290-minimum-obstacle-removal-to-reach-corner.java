class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] minObstacles = new int[n][m];
        int[][] directions = new int[][]{ { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };

        for (int i = 0; i < n; i++) {
            Arrays.fill(minObstacles[i], Integer.MAX_VALUE);
        }

        deque.add(new int[]{ 0, 0, 0 });

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            
            for (int[] direction : directions) {
                int x = current[0] + direction[0];
                int y = current[1] + direction[1];

                if (x < 0 || y < 0 || x >= n || y >= m || minObstacles[x][y] != Integer.MAX_VALUE)
                    continue;
                    
                if (grid[x][y] == 1) {
                    minObstacles[x][y] = current[2] + 1;
                    deque.addLast(new int[]{ x, y, current[2] + 1 });
                }

                else {
                    minObstacles[x][y] = current[2];
                    deque.addFirst(new int[]{ x, y, current[2] });
                }
            }  
        }

        return minObstacles[n - 1][m - 1];
    }
}