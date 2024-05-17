class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> lq = new PriorityQueue<>(candidates);
        PriorityQueue<Integer> rq = new PriorityQueue<>(candidates);

        int n = costs.length;
        int l = 0, r = n - 1;
        long totalCost = 0;

        while (l < candidates && l < n) {
            lq.add(costs[l++]);
        }

        while (r >= n - candidates && r >= l) {
            rq.add(costs[r--]);
        }

        while (k > 0) {
            if (!lq.isEmpty() && (rq.isEmpty() || lq.peek() <= rq.peek())) {
                totalCost += lq.poll();

                if (l <= r)
                    lq.add(costs[l++]); 
            } 
            
            else {
                totalCost += rq.poll();
                if (r >= l) 
                    rq.add(costs[r--]);
            }
            
            k--;
        }

        return totalCost;
    }
}
