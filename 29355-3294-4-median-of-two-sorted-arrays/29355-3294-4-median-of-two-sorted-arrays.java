class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, o = n + m;
        int[] combined = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n || j < m) {
            int n1 = (i < n) ? nums1[i] : 1_000_001;
            int n2 = (j < m) ? nums2[j] : 1_000_001;

            if (n1 < n2 || j >= m) {
                combined[k++] = n1;
                i++;
            }

            else {
                combined[k++] = n2;
                j++;
            }
        }
        
        // System.out.println(Arrays.toString(combined));

        return (o % 2 == 1) 
            ? (double) combined[(o / 2)]
            : ((double) (combined[(o / 2)] + combined[(o / 2) - 1]) / 2);
    }
}