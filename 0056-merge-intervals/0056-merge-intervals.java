class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
    
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] base = intervals[0];

        for (int i = 1; i < n; i++) {
            if ((base[1] >= intervals[i][0] && base[0] <= intervals[i][1])) {
                base[0] = Math.min(base[0], intervals[i][0]);
                base[1] = Math.max(base[1], intervals[i][1]);
            }

            else {
                list.add(base);
                base = intervals[i];
            }
        }

        list.add(base);
    
        return list.stream()
            .toArray(int[][]::new);
    }
}