class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        int[] save = null;

        if (a > 0) {
            pq.add(new int[] { 0, a });
        }

        if (b > 0) {
            pq.add(new int[] { 1, b });
        }

        if (c > 0) {
            pq.add(new int[] { 2, c });
        }

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();

            if (temp[1] == 1 || (save != null && save[1] > temp[1])) {
                sb.append((char) (temp[0] + 'a'));
                temp[1]--;
            }

            else if (temp[1] >= 2) {
                sb.append((char) (temp[0] + 'a'));
                sb.append((char) (temp[0] + 'a'));
                temp[1] -= 2;
            }

            if (save != null) {
                pq.add(save);
                save = null;
            }

            if (temp[1] > 0) {
                save = temp;
            }
        }

        return sb.toString();
    }
}