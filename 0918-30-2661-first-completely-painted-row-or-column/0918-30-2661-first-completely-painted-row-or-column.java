class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] rowCount = new int[n];
        int[] colCount = new int[m];
        Map<Integer, int[]> numToPos = new HashMap<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                int value = mat[row][col];
                numToPos.put(value, new int[] { row, col });
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int[] pos = numToPos.get(num);
            int row = pos[0];
            int col = pos[1];

            rowCount[row]++;
            colCount[col]++;

            if (rowCount[row] == m || colCount[col] == n) {
                return i;
            }
        }

        return -1; 
    }
}