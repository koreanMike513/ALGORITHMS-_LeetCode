class Solution {
    public int[] shortestToChar(String s, char c) {

        int len = s.length();
        int[] ans = new int[len];
        int prev = len;


        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                ans[i] = 0;
                prev = 0;
            }

            else {
                ans[i] = ++prev;
            }
        }

        for (int j = len - 1; j >= 0; j--) {
            if (s.charAt(j) == c) {
                ans[j] = Math.min(ans[j], 0);
                prev = 0;
            }

            else {
                ans[j] = Math.min(ans[j], ++prev);
            }
        }
    

        return ans;
    }
}