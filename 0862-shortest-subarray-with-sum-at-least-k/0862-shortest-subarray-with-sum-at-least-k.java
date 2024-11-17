
class Solution {
    static class Value {
        long ps;  
        int idx; 

        public Value(long ps, int idx) {
            this.ps = ps;
            this.idx = idx;
        }
    }

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE; 
        long csum = 0;

        PriorityQueue<Value> pq = new PriorityQueue<Value>(
                (a, b) -> Long.compare(a.ps, b.ps)
        );

        for (int i = 0; i < n; i++) {
            csum += nums[i]; 

            if (csum >= k) {
                ans = Math.min(ans, i + 1); 
            }

            while (!pq.isEmpty() && csum - pq.peek().ps >= k) {
                Value piece = pq.poll(); 
                ans = Math.min(ans, i - piece.idx);
            }

            pq.offer(new Value(csum, i));
        }

        return (ans == Integer.MAX_VALUE) ? - 1: ans;
    }

}