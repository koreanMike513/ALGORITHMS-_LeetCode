class Solution {
    static class NumberComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0];
        }
    }

    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new NumberComparator());
        Set<Integer> set = new HashSet<>();
        long scores = 0;

        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[]{ nums[i], i });
        }

        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && set.contains(pq.peek()[1])) {
                pq.poll();
            }

            if (pq.isEmpty())
                break;

            int[] cur = pq.poll();

            scores += cur[0];
            set.add(cur[1]);
            set.add(cur[1] + 1);
            set.add(cur[1] - 1);
        }

        return scores;
    }
}