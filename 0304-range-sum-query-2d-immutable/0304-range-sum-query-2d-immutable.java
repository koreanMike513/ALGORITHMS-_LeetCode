class NumMatrix {
    private int[][] sum;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        sum = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            int prefix = 0;
            for (int j = 0; j < m; j++) {
                prefix += matrix[i][j];
                sum[i + 1][j + 1] = prefix + sum[i][j + 1];
            }   
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;

        int bottomRight = sum[row2][col2];
        int above = sum[row1 - 1][col2];
        int left = sum[row2][col1 - 1];
        int topLeft = sum[row1 - 1][col1 - 1];

        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */