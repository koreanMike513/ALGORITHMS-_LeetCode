class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (char[] arr: board) {
            Set<Character> rows = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                if (rows.contains(arr[i])) return false;
                if (Character.isDigit(arr[i])) rows.add(arr[i]);
            }
        }

        for (int j = 0; j < board.length; j++) {
            Set<Character> columns = new HashSet<>();
            for (char[] arr: board) {
                if (columns.contains(arr[j])) return false;
                if (Character.isDigit(arr[j])) columns.add(arr[j]);
            }
        }

        for (int k = 0; k < board.length; k += 3) {
            Set<Character> blocks = new HashSet<>();
            int count = 0;
            for (char[] arr: board) {
                for (int l = k; l < k + 3; l++) {
                    if (blocks.contains(arr[l])) return false;
                    if (Character.isDigit(arr[l])) blocks.add(arr[l]);
                }
                count++;

                if (count == 3) {
                    blocks = new HashSet<>();
                    count = 0;
                }
            }
        }

        return true;
    }
}