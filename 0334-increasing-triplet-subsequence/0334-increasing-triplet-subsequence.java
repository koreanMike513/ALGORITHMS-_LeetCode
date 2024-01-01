class Solution {
    public boolean increasingTriplet(int[] nums) {
       int max1 = Integer.MAX_VALUE, max2 = Integer.MAX_VALUE;
       
       for (int n : nums) {
           if (n <= max1) max1 = n;
           else if (n <= max2) max2 = n;
           else return true;
       }
       
       return false;
    }
}