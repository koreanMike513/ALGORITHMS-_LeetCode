class Solution {
    public int matrixScore(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = (grid[i][j] == 0) ? 1 : 0; 
                }
            }
        }

        for (int k = 0; k < grid[0].length; k++) {
            int count0 = 0, count1 = 0;

            for (int l = 0; l < grid.length; l++) {
                if (grid[l][k] == 1) {
                    count1++;
                }

                else {
                    count0++;
                }
            }

            if (count0 > count1) {
                for (int l = 0; l < grid.length; l++) {
                    grid[l][k] = (grid[l][k] == 0) ? 1 : 0;
                }
            }
        }

        int sum = 0;

        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[m].length; n++) {
                sum += (int) Math.pow(2, grid[m].length - n - 1) * grid[m][n];
            }
        }

        return sum;
    }
}