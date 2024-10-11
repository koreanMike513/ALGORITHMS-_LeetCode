class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length, ans = 0;
        
        for (int i = 0; i < n; i++) {
            if (st.isEmpty() || nums[st.peek()] > nums[i]) {
                st.push(i);
            }
        }

        for (int i = n - 1; i > ans; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                ans = Math.max(ans, i - st.pop());
            }
        }

        return ans;
    }
}