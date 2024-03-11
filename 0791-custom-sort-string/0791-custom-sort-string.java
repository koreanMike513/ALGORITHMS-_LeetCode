class Solution {
    public String customSortString(String order, String s) {
        int[] alphabets = new int[26];
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            alphabets[c - 'a']++;
        }

        for (char c : order.toCharArray()) {
            while (alphabets[c - 'a'] > 0) {
                sb.append(c);
                alphabets[c - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            while (alphabets[i] > 0) {
                sb.append((char) (i + 'a'));
                alphabets[i]--;
            }
        }

        return sb.toString();
    }
}