class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length, res = 0, cummSum = 0;
        int[] map = new int[k];
        map[0] = 1;

        for (int num : nums) {
            cummSum += num % k;
            cummSum = (cummSum < 0) ? (cummSum + k) % k: cummSum % k;
            res += map[cummSum]++;
        }

        return res;
    }
}