class Solution {
    public int maximumDetonation(int[][] bombs) {
        int ans = 1;

        for (int i = 0; i < bombs.length; i++) {
            ans = Math.max(ans, calculateDetonation(bombs, i));
        }

        return ans;
    }

    public int calculateDetonation(int[][] bombs, int idx) {
        int count = 1, n = bombs.length;
        boolean[] bombed = new boolean[n];
        Queue<int[]> qu = new LinkedList<>();

        bombed[idx] = true;
        qu.add(bombs[idx]);

        while (!qu.isEmpty()) {
            int[] current = qu.poll();

            for (int i = 0; i < n; i++) {
                if (!bombed[i] && isInRange(current, bombs[i])) {
                    qu.add(bombs[i]);
                    bombed[i] = true;
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isInRange(int[] point1, int[] point2) {
        long dx = point1[0] - point2[0], dy = point1[1] - point2[1], radius = point1[2];
        long distance =  dx * dx + dy * dy;
        return distance <= radius * radius;
    }
}