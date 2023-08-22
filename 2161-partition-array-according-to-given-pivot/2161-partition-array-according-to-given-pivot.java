class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int i = 0, j = nums.length - 1, p = i, q = j;

        while (i < nums.length && j >= 0) {
            if (nums[i] < pivot) ans[p++] = nums[i];
            if (nums[j] > pivot) ans[q--] = nums[j];

            i++; j--;
        }

        while (p <= q) ans[p++] = pivot;

        return ans;
    }
}