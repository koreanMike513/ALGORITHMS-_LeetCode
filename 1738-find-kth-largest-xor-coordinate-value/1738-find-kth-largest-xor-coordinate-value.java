class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length, xor = 0;
        int[][] bits = new int[n][m];

        for (int i = 0; i < n; i++) {
            xor ^= matrix[i][0];
            bits[i][0] = xor;
        }

        xor = 0;

        for (int i = 0; i < m; i++) {
            xor ^= matrix[0][i];
            bits[0][i] = xor;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                bits[i][j] = bits[i - 1][j] ^ bits[i][j - 1] ^ bits[i - 1][j - 1] ^ matrix[i][j];
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pq.add(bits[i][j]);
            }
        }

        while (k > 1) {
            pq.poll();
            k--;
        }

        return pq.poll();
    }
}