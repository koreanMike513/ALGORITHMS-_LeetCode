class NumArray {
    private int[] prefixSums;

    public NumArray(int[] nums) {
        int n = nums.length;
        prefixSums = new int[n];   
        prefixSums[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        int offset = (left == 0) ? 0 : prefixSums[left - 1];
        return prefixSums[right] - offset;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */