class Solution {
    public char[][] rotateTheBox(char[][] box) {
        char[][] ans = new char[box[0].length][box.length];
        int row = 0, column = box.length - 1;

        for (int i = 0; i < box.length; i++) {
            char[] arr = box[i];
            for (int j = 0; j < arr.length; j++) {
                ans[row++][column] = arr[j];
            }

            row = 0;
            column--;
        }

        for (int k = ans.length - 1; k >= 0 ; k--) {
            for (int l = 0; l < ans[k].length; l++) {
                if (ans[k][l] == '#') {
                    int m = k;
                    while (m < ans.length - 1 && ans[m + 1][l] =='.') {
                        char stone = ans[m][l];
                        ans[m][l] = ans[m + 1][l];
                        ans[m + 1][l] = stone;
                        m++;
                    }
                }
            }
        }

        return ans;
    }
}