class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0];
        });
        
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[]{ nums[i], i });
        }

        while (k > 0) {
            int[] min = pq.poll();
            min[0] *= multiplier;
            pq.add(min);
            k--;
        }

        while (!pq.isEmpty()) {
            int[] num = pq.poll();
            ans[num[1]] = num[0];
        }

        return ans;
    }
}