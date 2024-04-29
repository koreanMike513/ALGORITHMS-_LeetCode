class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        int ans[] = new int[2]; 

        for (int num : nums) {
            xor ^= num;
        }

        int bit = xor & ~(xor-1), num1 = 0, num2 = 0;

        for (int num : nums) {
            if ((num & bit) > 0)
                num1 ^= num;
            else
                num2 ^= num;
        }

        ans[0] = num1;
        ans[1] = num2;

        return ans;
    }
}