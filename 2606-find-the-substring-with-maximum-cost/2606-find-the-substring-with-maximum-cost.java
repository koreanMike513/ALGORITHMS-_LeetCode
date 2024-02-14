class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int n = s.length(), ans = 0;
        char[] ca = chars.toCharArray();
        int[] dp = new int[n];
        int[] alphabets = new int[26];

        Arrays.fill(alphabets, -1001);

        for (int i = 0; i < ca.length; i++) {
            alphabets[ca[i] - 'a'] = vals[i];
        }

        dp[0] = (alphabets[s.charAt(0) - 'a'] == -1001) ? (s.charAt(0) - 'a' + 1) : alphabets[s.charAt(0) - 'a'];
        ans = Math.max(ans, dp[0]);

        for (int i = 1; i < s.length(); i++) {
            int value = (alphabets[s.charAt(i) - 'a'] == -1001) ? (s.charAt(i) - 'a' + 1) : alphabets[s.charAt(i) - 'a'];
            dp[i] = Math.max(dp[i - 1] + value, value);
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}