class Solution {
    public int balancedStringSplit(String s) {
        int countL = 0, countR = 0, ans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'L') {
                countL++;
            }

            else {
                countR++;
            }

            if (countL == countR) {
                ans++;
            }
        }

        return ans;
    }
}