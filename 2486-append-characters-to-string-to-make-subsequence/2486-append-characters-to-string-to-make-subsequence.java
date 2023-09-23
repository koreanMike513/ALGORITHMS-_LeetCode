class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            char sc = s.charAt(i);
            char tc = t.charAt(j);

            if (sc == tc) {
                i++;
                j++;
            }

            else {
                i++;
            }
        }

        return t.length() - j;
    }
}