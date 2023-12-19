class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length, m = img[0].length;
        int[][] eimg = new int[n + 2][m + 2];
        int[][] ans = new int[n][m];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                eimg[i][j] = img[i - 1][j - 1];
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                ans[i - 1][j - 1] = calculateImg(eimg, i, j);
            }
        }

        return ans;
    }

    public int calculateImg(int[][] eimg, int x, int y) {
        int sum = 0, count = 0;

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i == 0 || j == 0 || i == eimg.length - 1 || j == eimg[0].length - 1) count++;
                sum += eimg[i][j];
            }
        }

        return (int) Math.floor(sum / (9 - count));
    }
}