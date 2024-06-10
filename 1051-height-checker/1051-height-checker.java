class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length, ans = 0;
        int[] expected = Arrays.copyOf(heights, n);

        Arrays.sort(expected);

        for (int i = 0; i < n; i++) {
            if (expected[i] != heights[i])
                ans++;
        }

        return ans;
    }
}