class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int gift : gifts) {
            pq.add(gift);
        }

        while (k > 0 && !pq.isEmpty()) {
            int gift = pq.poll();
            pq.add((int) Math.floor(Math.sqrt(gift)));
            k--;
        }

        long sum = 0;

        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }
}