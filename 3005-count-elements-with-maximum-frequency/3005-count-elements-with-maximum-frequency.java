class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length, max = 0, maxFreq = 0, ans = 0;
        
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] freq = new int[max + 1];

        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
            maxFreq = Math.max(maxFreq, freq[nums[i]]);
        }

        for (int i = 0; i <= max; i++) {
            if (freq[i] == maxFreq) ans += maxFreq;
        }

        return ans;
    }
}