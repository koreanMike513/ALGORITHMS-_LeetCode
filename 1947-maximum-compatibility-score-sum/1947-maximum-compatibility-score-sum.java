class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int n = students.length, m = mentors.length;
        int[][] scores = new int[n][m];
        boolean[] visited = new boolean[students.length]; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                scores[i][j] = findScore(students[i], mentors[j]);
            }
        }

        return maxCompatibilitySum(scores, visited, 0);
    }

    public int maxCompatibilitySum(int[][] scores, boolean[] visited, int row) {
        if (row == scores.length) {
            return 0;
        }

        int res = 0;

        for (int i = row; i < scores.length; i++) {
            for (int j = 0; j < scores[0].length; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    res = Math.max(
                        res, scores[i][j] + maxCompatibilitySum(scores, visited, i + 1));
                    visited[j] = false;
                }
            }
        }

        return res;
    }

    public int findScore(int[] student, int[] mentor) {
        int ans = 0;

        for (int i = 0; i < student.length; i++) {
            ans += (student[i] == mentor[i]) ? 1: 0;
        }

        return ans;
    }
}