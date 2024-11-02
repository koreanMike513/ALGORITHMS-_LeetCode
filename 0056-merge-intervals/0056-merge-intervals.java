class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] interval = intervals[0];

        for (int i = 1; i < n; i++) {
            if (interval[1] >= intervals[i][0] && interval[0] <= intervals[i][1]) {
                interval[0] = Math.min(interval[0], intervals[i][0]);
                interval[1] = Math.max(interval[1], intervals[i][1]);
            }

            else {
                list.add(interval);
                interval = intervals[i];
            }
        }

        list.add(interval);

        return list.stream()
            .toArray(int[][]::new);
    }
}