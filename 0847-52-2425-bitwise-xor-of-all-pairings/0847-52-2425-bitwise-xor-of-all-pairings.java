class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, ans = 0;
        int[] bits = new int[32];

        for (int num : nums1) {
            for (int i = 0; i < 32 && num > 0; i++) {
                if ((num & 1) == 1)
                    bits[i] = (bits[i] + (m % 2)) % 2;

                num = num >> 1;
            }
        }

        for (int num : nums2) {
            for (int i = 0; i < 32 && num > 0; i++) {
                if ((num & 1) == 1)
                    bits[i] = (bits[i] + (n % 2)) % 2;

                num = num >> 1;
            }
        }

        for (int i = 31; i >= 0; i--) {
            ans = (ans << 1) | bits[i];
        }

        return ans;
    }
}