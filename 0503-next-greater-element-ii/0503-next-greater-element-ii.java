class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ans[stack.pop()] = nums[i % n];
            }

            if (i < n) stack.push(i);
        }

        return ans;
    }
}