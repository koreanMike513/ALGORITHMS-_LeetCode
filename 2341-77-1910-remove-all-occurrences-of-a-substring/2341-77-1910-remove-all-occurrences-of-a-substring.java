class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int m = part.length();

        for (char c : s.toCharArray()) {
            sb.append(c);

            if (sb.length() >= m) {
                int n = sb.length();

                if (part.equals(sb.substring(n - m, n)))
                    sb = new StringBuilder(sb.substring(0, n - m));
            }
        }

        return sb.toString();
    }
}