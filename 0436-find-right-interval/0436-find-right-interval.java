class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[n];
        map.put(Integer.MIN_VALUE, -1);

        for (int i = 0; i < n; i++) {
            map.put(intervals[i][0], i);
        }

        Arrays.sort(intervals, (a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            ans[map.get(intervals[i][0])] = map.get(findRightInterval(intervals, i));
            
        }

        return ans;
    }

    public int findRightInterval(int[][] intervals, int idx) {
        int start = 0, end = idx, interval = Integer.MIN_VALUE;
   
        while (start <= end) {
            int mid = (end + ((start - end) / 2));
            int current = intervals[mid][0];

            if (current < intervals[idx][1]) {
                end = mid - 1;
            }

            else {
                interval = current;
                start = mid + 1;
            }
        }

        return interval;
    }
}