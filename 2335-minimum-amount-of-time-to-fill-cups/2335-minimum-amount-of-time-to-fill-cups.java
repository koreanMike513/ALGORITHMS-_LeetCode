class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int a : amount) {
            pq.add(a);
        }

        int ans = 0;

        while (pq.peek() > 0) {
            int first = pq.poll();
            int second = pq.poll();

            pq.add(first - 1);
            pq.add(second - 1);

            ans++;
        }

        return ans;
    }
}