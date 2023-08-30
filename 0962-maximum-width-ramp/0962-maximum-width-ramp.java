class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int max = 0, len = nums.length;
        
        for (int i= 0; i < len; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.add(i);
            }
        }

        for (int i = len - 1; i > max; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                max = Math.max(max, i - stack.pop());
            }
        }

        return max;
    }
}