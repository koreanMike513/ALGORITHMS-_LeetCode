class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> 
            (Math.abs(a[0] - 0) * Math.abs(a[0] - 0) + Math.abs(a[1] - 0) * Math.abs(a[1] - 0)) - 
            (Math.abs(b[0] - 0) * Math.abs(b[0] - 0) + Math.abs(b[1] - 0) * Math.abs(b[1] - 0)));

        int[][] ans = new int[k][2];

        for (int[] point : points) {
            pq.add(point);
        }

        int i = 0;

        while (k > 0) {
            ans[i++] = pq.poll();
            k--;
        }

        return ans;
    }
}