class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> zeroes = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) 
                    zeroes.add(new int[]{ i, j });
            }
        }

        for (int[] zero : zeroes) {
            setZero(matrix, zero[0], zero[1]);
        }
    }

    private void setZero(int[][] matrix, int x, int y) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][y] = 0;
        }

        for (int j = 0; j < matrix[0].length; j++) {
            matrix[x][j] = 0;
        }
    }
}