class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int[] dp = new int[word.length()];
        Arrays.fill(dp, -1);
        return removeAlmostEqualCharacters(dp, word, 0);
    }

    public int removeAlmostEqualCharacters(int[] dp, String word, int idx) {
        if (idx >= word.length())
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int res = word.length();

        if (idx < word.length() - 1 && (word.charAt(idx) == word.charAt(idx + 1) || Math.abs((word.charAt(idx) - '0') - (word.charAt(idx + 1) - '0')) == 1))
            res = Math.min(res, 1 + removeAlmostEqualCharacters(dp, word, idx + 2));
        
        else
            res = Math.min(res, removeAlmostEqualCharacters(dp, word, idx + 1));

        return dp[idx] = (res != word.length()) ? res : 0;
    }
}