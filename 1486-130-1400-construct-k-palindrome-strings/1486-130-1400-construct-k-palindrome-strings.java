class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k)
            return false;

        int[] letters = new int[26];

        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] % 2 == 1)
                k--;
        } 

        return k >= 0;
    }
}