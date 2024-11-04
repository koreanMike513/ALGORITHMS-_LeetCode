class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int n = word.length();

        for (int i = 0; i < n; i++) {
            int start = i;

            while (i + 1 < n && word.charAt(i) == word.charAt(i + 1)) {
                i++;
            }

            int m = i - start + 1;

            while (m / 9 > 0) {
                sb.append("9").append(word.charAt(i));
                m -= 9;
            }

            if (m > 0)
                sb.append(m % 9).append(word.charAt(i));
        }

        return sb.toString();
    }
}