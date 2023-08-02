class Solution {
    public int nextGreaterElement(int n) {
        
        String temp = Integer.toString(n);
        int[] nums = new int[temp.length()];

        for (int i = 0; i < temp.length(); i++) {
            nums[i] = temp.charAt(i) - '0';
        }
            
        long ans = find(nums);

        return (ans > Integer.MAX_VALUE || n == ans) ? - 1 : (int) ans;
    }

    public long find(int[] nums) {
        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        int j = nums.length - 1;

        if (i >= 0) {
            while (i < j && nums[j] <= nums[i]) j--;

            swap(nums, i, j);
            reverse(nums, i + 1, nums.length - 1);
        }
        
        long num = 0;

        for (int k = 0; k < nums.length; k++) {
            num = num * 10 + nums[k];
        }

        return num;
    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}