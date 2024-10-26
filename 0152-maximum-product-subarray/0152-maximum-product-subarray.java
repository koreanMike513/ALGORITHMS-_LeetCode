class Solution {
    public int maxProduct(int[] nums) {
        int max = 1, min = 1, ans = -10;

        for (int n : nums) {
            if (n < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(n, max *= n);
            min = Math.min(n, min *= n);
            ans = Math.max(ans, max);
        }

        return ans;
    }
}