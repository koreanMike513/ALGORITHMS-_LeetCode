class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Queue<int[]> qu = new LinkedList<>();
        int[][] directions = new int[][] { 
            { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, -1 }, { 1, 1 }, { -1, -1 }, { -1, 1 } 
        };

        int[][] vis = new int[n][n];
        
        if (grid[0][0] == 1) {
            return -1;
        }

        qu.add(new int[] { 0, 0 });
        int steps = 1;

        while (!qu.isEmpty()) {
            int size = qu.size();

            for (int i = 0; i < size; i++) {
                int[] current = qu.poll();

                if (current[0] == n - 1 && current[1] == n - 1 && grid[current[0]][current[1]] == 0) {
                    return steps;
                }

                for (int[] direction : directions) {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];

                    if (x >= 0 && x < n && y >= 0 && y < n && vis[x][y] == 0 && grid[x][y] == 0) {
                        qu.add(new int[] { x, y });
                        vis[x][y] = 1;
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}