class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size(), min = 1441, ans = 1441; 
        int[] times = new int[n + 1];

        for (int i = 0; i < n; i++) {
            times[i] = convertTimeStringToInt(timePoints.get(i));
            min = Math.min(min, times[i]);
        }

        times[n] = min + 24 * 60;
        Arrays.sort(times);

        for (int i = 1; i < n + 1; i++) {
            if (ans > times[i] - times[i - 1])
                ans = times[i] - times[i - 1];
        }
        
        return ans;
    }

    private int convertTimeStringToInt(String time) {
        String[] timeFormat = time.split(":");
        int h = Integer.valueOf(timeFormat[0]), m = Integer.valueOf(timeFormat[1]);

        return h * 60 + m;
    }
}