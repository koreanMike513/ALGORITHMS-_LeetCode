class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        Set<Integer> mins = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int min = 100001;
            for (int j = 0; j < m; j++) {
                min = Math.min(min, matrix[i][j]);
            }

            mins.add(min);
        }

        for (int j = 0; j < m; j++) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, matrix[i][j]);
            }

            if (mins.contains(max))
                ans.add(max);
        }
        
        return ans;
    }
}