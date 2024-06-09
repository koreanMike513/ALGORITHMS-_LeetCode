class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<int[]> qu = new LinkedList<>();
        boolean[] vis = new boolean[n * n + 1];
        qu.add(new int[]{ 1, 0 });
        vis[1] = true;

        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                int[] current = qu.poll();

                if (current[0] == n * n)
                    return current[1];

                for (int k = 1; k <= 6; k++) {
                    int next = current[0] + k;
                    if (next > n * n)
                        break;

                    int[] coords = getCoordinates(next, n);

                    if (board[coords[0]][coords[1]] > 0)
                        next = board[coords[0]][coords[1]];

                    if (!vis[next]) {
                        vis[next] = true;
                        qu.add(new int[] { next, current[1] + 1 });
                    }
                }
            }
        }

        return -1;
    }

    private int[] getCoordinates(int c, int n) {
        int x = (c - 1) / n;
        int y = (c - 1) % n;

        if (x % 2 == 1)
            y = n - y - 1;

        x = n - 1 - x;

        return new int[] { x, y };
    }
}