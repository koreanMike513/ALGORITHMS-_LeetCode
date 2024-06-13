class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] ans = new int[k];

        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[]{ nums[i], i });
        }

        while (pq.size() > k) {
            pq.poll();
        }

        while (!pq.isEmpty()) {
            pq2.add(pq.poll());
        }

        for (int i = 0; i < k; i++) {
            int[] current = pq2.poll();
            ans[i] = current[0];
        }

        return ans;
    }
}