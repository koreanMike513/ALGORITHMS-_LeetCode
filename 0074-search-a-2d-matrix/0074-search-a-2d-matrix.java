class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length, start = 0, end = m - 1, row = 0;

        while (start <= end && row < n) {
            if (target > matrix[row][end])
                row++;
            
            else {
                int mid = (start + end) / 2;
                int current = matrix[row][mid];

                if (target == current) 
                    return true;
                
                else if (target < current) {
                    end = mid - 1;
                }

                else {
                    start = mid + 1;
                }
            }
        }

        return false;
    }
}