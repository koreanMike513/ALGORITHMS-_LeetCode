class Solution {
    public int minGroups(int[][] intervals) {
        PriorityQueue<Integer> start = new PriorityQueue<>();
        PriorityQueue<Integer> end = new PriorityQueue<>();

        for (int[] interval : intervals) {
            start.add(interval[0]);
            end.add(interval[1]);
        }

        int ans = 0, group = 0;

        while (!start.isEmpty()) {
            if (start.peek() <= end.peek()) {
                group++;
                start.poll();
            }

            else {
                group--;
                end.poll();
            }

            ans = Math.max(ans, group);
        }

        return ans;
    }
}