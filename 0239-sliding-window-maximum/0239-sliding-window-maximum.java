class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i < n; i++) {

            while (deque.size() > 0 && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (deque.size() > 0 && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i - k + 1 >= 0) 
                ans[i - k + 1] = nums[deque.peek()];
        }

        return ans;
    }
}