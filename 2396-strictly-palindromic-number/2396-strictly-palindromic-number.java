class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for (int i = n - 2; i >= 2; i--) {
            String num = Integer.toString(n, i);
            int j = 0, k = num.length() - 1;
            
            while (j <= k) {
                if (num.charAt(j++) != num.charAt(k--)) return false;
            }
        }

        return true;
    }
}