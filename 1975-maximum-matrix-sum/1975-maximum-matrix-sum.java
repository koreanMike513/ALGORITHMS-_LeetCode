class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length, min = 100_001, negatives = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] < 0)
                    negatives++;
                
                int v = Math.abs(matrix[i][j]);
                sum += v;
                min = Math.min(min, v);
            }
        }

        if (negatives % 2 == 1)
            sum -= 2 * min;

        return sum;
    }
}