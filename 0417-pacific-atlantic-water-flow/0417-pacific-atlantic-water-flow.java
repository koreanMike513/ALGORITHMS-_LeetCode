class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = heights.length, m = heights[0].length;

        if (heights == null || n == 0 || m == 0) {
            return ans;
        }

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, m-1});
            pacific[i][0] = true;
            atlantic[i][m-1] = true; 
        }

        for(int i = 0; i < m; i++) {
            pQueue.offer(new int[]{ 0, i });
            aQueue.offer(new int[]{ n  -1, i });
            pacific[0][i] = true;
            atlantic[n - 1][i] = true;
        }

        BFS(pQueue, pacific, heights);
        BFS(aQueue, atlantic, heights);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }

        return ans;
    }

    public void BFS(Queue<int[]> queue, boolean[][] visited, int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[][] directions = new int[][]{{ 1, 0 }, { -1, 0 }, { 0 ,1 }, { 0, -1 }};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] direction : directions) {
                int x = current[0] + direction[0];
                int y = current[1] + direction[1];

                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || heights[x][y] < heights[current[0]][current[1]]) {
                    continue;
                }

                visited[x][y] = true;
                queue.add(new int[] { x, y });
            }
        }
    }
}