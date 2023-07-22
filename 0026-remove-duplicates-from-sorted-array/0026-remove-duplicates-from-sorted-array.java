class Solution {
  public int removeDuplicates(int[] nums) {
      int j = 0;

      for (int i = 0; i < nums.length; i++) {
        int base = nums[i];
        
        while (i < nums.length - 1 && base == nums[i + 1]) {
          i++;
        }

        nums[j] = base;
        j++;
      }

    return j;
  }
}