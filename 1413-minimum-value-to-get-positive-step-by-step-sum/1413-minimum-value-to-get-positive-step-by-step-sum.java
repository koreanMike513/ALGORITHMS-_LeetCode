class Solution {
    public int minStartValue(int[] nums) {
        int prefix = 0, sum = 0; 

        for (int num : nums) {
            sum += num;
            prefix = Math.min(prefix, sum);
        }

        return 1 - prefix;
    }
}