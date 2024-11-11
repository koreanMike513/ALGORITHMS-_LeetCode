class Solution {
    public boolean isAnagram(String s, String t) {
        int[] characters = new int[26];

        for (char c : s.toCharArray()) {
            characters[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            characters[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (characters[i] != 0)
                return false;
        }

        return true;
    }
}