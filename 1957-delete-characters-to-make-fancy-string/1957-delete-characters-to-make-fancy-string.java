class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int j = i;

            while (j + 1 < n && s.charAt(j + 1) == c) {
                j++;
            }

            if (j - i + 1 >= 2) {
                for (int k = 0; k < 2; k++) {
                    sb.append(c);
                }
            }

            else {
                sb.append(c);
            }

            i = j;
        }

        return sb.toString();
    }
}