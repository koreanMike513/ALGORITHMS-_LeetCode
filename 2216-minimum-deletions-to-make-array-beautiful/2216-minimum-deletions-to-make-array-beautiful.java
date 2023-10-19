class Solution {
    public int minDeletion(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int delete = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!st.isEmpty() && st.size() % 2 == 1 && nums[st.peek()] == nums[i]) {
                delete++;
            }

            else {
                st.push(i);
            }
        }

        return delete + st.size() % 2;
    }
}