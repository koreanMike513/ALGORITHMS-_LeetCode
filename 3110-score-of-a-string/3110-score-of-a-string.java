class Solution {
    public int scoreOfString(String s) {
        int prev = (int) (s.charAt(0) - 'a'), ans = 0;

        for (int i = 1; i < s.length(); i++) {
            ans += Math.abs(prev - (int) (s.charAt(i) - 'a'));
            prev = (int) (s.charAt(i) - 'a');
        }

        return ans;
    }
}