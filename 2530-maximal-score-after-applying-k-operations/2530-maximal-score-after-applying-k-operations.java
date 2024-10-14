class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long ans = 0;

        for (int num : nums) {
            pq.add(num);
        }

        while(k > 0) {
            long score = (long) pq.poll();
            
            ans += score;
            pq.add((int) Math.ceil((double) score / 3));
            k--;
        }

        return ans;
    }
}