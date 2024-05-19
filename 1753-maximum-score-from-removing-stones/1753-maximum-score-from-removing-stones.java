class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);

        pq.add(a);
        pq.add(b);
        pq.add(c);

        int ans = 0;

        while (true) {
            int count = 0;
            int h = pq.poll();
            int k = pq.poll();
            int l = pq.poll();

            if (h <= 0) count++;
            if (k <= 0) count++;
            if (l <= 0) count++;

            if (count >= 2)
                break;

            pq.add(h - 1);
            pq.add(k - 1);
            pq.add(l);

            ans++;
        }

        return ans;
    }
}