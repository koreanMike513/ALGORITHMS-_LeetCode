class Solution {
    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                while (i < j && s.charAt(j) == s.charAt(j - 1)) j--;
                while (i < j && s.charAt(i) == s.charAt(i + 1)) i++;
                
                if (i == j) return 0;
            }

            else {
                break;
            }

            i++; j--;
        }

        return j - i + 1;
    }
}