class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length, targetStart = times[targetFriend][0];

        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> available = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            available.add(i);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= times[i][0]) {
                available.add(pq.poll()[1]);
            }
            
            if (times[i][0] == targetStart) {
                break;
            }
            
            pq.add(new int[]{ times[i][1], available.poll() });
        }
        
        return available.peek();
    }
}