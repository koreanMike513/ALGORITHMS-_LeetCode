class Solution {
    public boolean makeEqual(String[] words) {
        if (words == null || words.length == 1) {
            return true;
        }

        int[] map = new int[26];

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                map[word.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (map[i] > 0 && map[i] % words.length != 0) {
                return false;
            }
        }

        return true;
    }
}