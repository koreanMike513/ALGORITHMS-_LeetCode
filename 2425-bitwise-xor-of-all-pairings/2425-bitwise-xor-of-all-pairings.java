class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        // n10, n11, n12
        // n20, n21, n22,

        // [ 
        //     n10 ^ n20, n10 ^ n21, n10 ^ n22, 
        //     n11 ^ n20, n11 ^ n21, n11 ^ n22,
        //     n12 ^ n20, n12 ^ n21, n12 ^ n22,
        // ] = n10 ^ n11 ^ n12 ^ n20, ^ n21, ^ n22

        // n10, n11, n12
        // n20, n21, n22, n23

        // [ 
        //     n10 ^ n20, n10 ^ n21, n10 ^ n22, n10 ^ n23
        //     n11 ^ n20, n11 ^ n21, n11 ^ n22, n11 ^ n23
        //     n12 ^ n20, n12 ^ n21, n12 ^ n22, n12 ^ n23

        // ] = n20, ^ n21, ^ n22 ^ n23

        // n10, n11, n12, n13
        // n20, n21, n22

        // [ 
        //     n10 ^ n20, n10 ^ n21, n10 ^ n22
        //     n11 ^ n20, n11 ^ n21, n11 ^ n22
        //     n12 ^ n20, n12 ^ n21, n12 ^ n22
        //     n13 ^ n20, n13 ^ n21, n13 ^ n22
            
        // ] = n10 ^ n11 ^ n12 ^ n13

        int n1 = nums1.length, n2 = nums2.length, ans = 0;
        
        if (n2 % 2 == 1) {
            for (int n : nums1) {
                ans ^= n;
            }
        }

        if (n1 % 2 == 1) {
            for (int n : nums2) {
                ans ^= n;
            }
        }

        return ans;
    }
}