class Solution {
    public int maxScore(String s) {
        int n = s.length(), zeroes = 0, ones = 0, maxScore = 0;
        int[] zero = new int[n], one = new int[n];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '0')
                zeroes++;
            
            zero[i] = zeroes;
        }

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '1')
                ones++;
            
            one[i] = ones;
        }

        for (int i = 0; i < n - 1; i++) {
            if (maxScore < zero[i] + one[i + 1])
                maxScore = zero[i] + one[i + 1];
        }

        return maxScore;
    }
}