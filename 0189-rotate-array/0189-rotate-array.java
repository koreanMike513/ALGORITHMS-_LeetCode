class Solution {
    public void rotate(int[] nums, int k) {
        int l = 0;

        if (k > nums.length) k = k % nums.length;
        if (k == 0) return;

        int[] reps = new int[k];

        for (int i = nums.length - k; i < nums.length; i++) {
            reps[l++] = nums[i];
        }

        for (int j = nums.length - k - 1; j >= 0; j--) {
            nums[j + k] = nums[j];
        }

        l = 0;

        for (int rep: reps) {
            nums[l++] = rep;
        }
    }
}