class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = nums1.length - 1, j = nums2.length - 1, max = 0;
        
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                j--;
            }

            else {
                if (j - i > max) {
                    max = j - i;
                }

                i--;
            }

        }

        return max;
    }
}