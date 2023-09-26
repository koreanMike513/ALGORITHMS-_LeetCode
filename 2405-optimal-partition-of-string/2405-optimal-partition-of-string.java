class Solution {
    public int partitionString(String s) {
        int[] map = new int[26];
        int substrings = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map[c - 'a'] > 0) {
                map = new int[26];
                substrings++;
            }

            map[c - 'a']++;
        }

        return substrings;
    }
}