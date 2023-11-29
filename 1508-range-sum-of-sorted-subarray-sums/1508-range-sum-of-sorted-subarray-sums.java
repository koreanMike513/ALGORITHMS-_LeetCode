class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int idx = 0;
        int[] sums = new int[n * (n + 1) / 2];

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                sums[idx++] = sum;
            }
        }

        int ans = 0;
        Arrays.sort(sums);

        for (int i = left - 1; i < right; i++) {
            ans = (ans + sums[i]) % 1000000007;
        } 

        return ans;
    }
}