class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 1;
        int[][] rows = new int[n][m];
        int[][] cols = new int[n][m];
        int[][] diar = new int[n][m];
        int[][] dial = new int[n][m];
        boolean[][] map = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rows[i][j] = (j == 0) ? grid[i][j] : grid[i][j] + rows[i][j - 1];
                cols[i][j] = (i == 0) ? grid[i][j] : grid[i][j] + cols[i - 1][j];
                diar[i][j] = (i == 0 || j == 0) ? grid[i][j] : grid[i][j] + diar[i - 1][j - 1];
                dial[i][j] = (i == 0 || j == m - 1) ? grid[i][j] : grid[i][j] + dial[i - 1][j + 1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = i, l = j ; k < n && l < m; k++, l++){
                    int match = rows[i][l] - (j - 1 >= 0 ? rows[i][j - 1] : 0);
                    if (!findRow(rows, i, k, j, l, match)) continue;
                    if (!findCol(cols, i, k, j, l, match)) continue;
                    if (!findDiag(diar, i, k, j, l, match)) continue;
                    if (!findAnti(dial, i, k, j, l, match)) continue;

                    ans = Math.max(ans, k - i + 1);
                }    
            }
        }

        return ans;
    }

    public boolean findRow(int rows[][], int i, int k, int j, int l, int req) {
        for (int h = i; h <= k; h++){
            int sum = rows[h][l] - (j - 1 >= 0 ? rows[h][j - 1] : 0);        
            if (sum != req) return false;
        }

        return true;
    }

    public boolean findCol(int cols[][], int i, int k, int j, int l, int req) {
        for (int h = j; h <= l; h++){
            int sum = cols[k][h] - (i - 1 >= 0 ? cols[i - 1][h] : 0);        
            if (sum != req) return false;
        }

        return true;
    }

    public boolean findDiag(int diar[][], int i, int k, int j, int l, int req) {
        return (diar[k][l] - (i - 1 >= 0 && j - 1 >= 0 ? diar[i - 1][j - 1] : 0)) == req;
    }

    public boolean findAnti(int dial[][], int i, int k, int j, int l, int req) {
        return (dial[k][j] - (i - 1 >= 0 && l + 1 < dial[0].length ? dial[i - 1][l + 1] : 0)) == req;
    }
}