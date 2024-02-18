class Solution {
    public long[] findPrefixScore(int[] nums) {
        long prefixConver = 0; 
        int max = 0, n = nums.length;
        long[] ans = new long[n];

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefixConver += (long) max + (long) nums[i];
            ans[i] = prefixConver;
        }

        return ans;
    }
}