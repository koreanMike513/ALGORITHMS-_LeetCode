class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length, m = maze[0].length, ans = 0;
        Queue<int[]> qu = new LinkedList<>();

        maze[entrance[0]][entrance[1]] = '+';
        qu.add(entrance);

        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        while (!qu.isEmpty()) {
            ans++;
            
            int size = qu.size();

            for (int i = 0; i < size; i++) {
                int[] current = qu.poll();

                for (int[] direction : directions) {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];

                    if (x < 0 || x >= n || y < 0 || y >= m || maze[x][y] == '+')
                        continue;
                    
                    if (x == 0 || x == n - 1 || y == 0 || y == m - 1) 
                        return ans;
                    
                    maze[x][y] = '+';
                    qu.add(new int[] { x, y });
                }
            }
        }

        return -1;
    }
}