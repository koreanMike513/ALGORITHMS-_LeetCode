class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box[0].length, m = box.length;
        char[][] ans = new char[n][m];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                ans[j][m - i - 1] = box[i][j];
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (ans[i][j] == '#') 
                    applyGravity(ans, i, j);
            }
        }

        return ans;
    }

    private void applyGravity(char[][] ans, int x, int y) {
        while (x + 1 < ans.length && ans[x + 1][y] == '.') {
            char temp = ans[x][y];
            ans[x][y] = ans[x + 1][y];
            ans[x + 1][y] = temp;
            x++;
        }
    }
}