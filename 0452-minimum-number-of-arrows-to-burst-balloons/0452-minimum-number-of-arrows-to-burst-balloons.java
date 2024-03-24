class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1]));

        int start = points[0][0], end = points[0][1], ans = 1;

        for (int i = 1; i < points.length; i++) {
            if (end < points[i][0]) {
                start = points[i][0];
                end = points[i][1];
                ans++;
            }

            else {
                start = Math.max(start, points[i][0]);
                end = Math.min(end, points[i][1]);
            }
        }

        return ans;
    }
}