class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (newInterval[1] < intervals[i][0]) {
                list.add(newInterval);
                newInterval = intervals[i];
            }

            else if (intervals[i][1] < newInterval[0]) {
                list.add(intervals[i]);
            }

            else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }

        list.add(newInterval);

        return list.stream()
            .toArray(int[][]::new);
    }
}