class Solution {
    public String reverseWords(String s) {
        String result = "";
        StringBuilder t = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') t.append(s.charAt(i));
            else if (s.charAt(i) == ' ' && t.length() > 0) {
                result += t.reverse().toString() + " ";
                t.delete(0, t.length());
            }
            
        }
        result += t.reverse().toString();

        return result.trim();
    }
}