class Solution {
    public boolean areOccurrencesEqual(String s) {
        int freq = 0;
        int[] hash = new int[26];

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
            freq = hash[s.charAt(i) - 'a'];
        } 

        for (int i = 0; i < 26; i++) {
            if (hash[i] > 0 && freq != hash[i]) {
                return false;
            }
        }

        return true;
    }
}