class Solution {
    public int numberOfBeams(String[] bank) {
        int prevSecurity = 0, ans = 0;

        for (int k = 0; k < bank[0].length(); k++) {
            if (bank[0].charAt(k) == '1') {
                prevSecurity++;
            }
        }

        for (int i = 1; i < bank.length; i++) {
            int currSecurity = 0;

            for (int j = 0; j < bank[0].length(); j++) {
                if (bank[i].charAt(j) == '1') {
                    currSecurity++;
                }

            }

            ans += (prevSecurity * currSecurity);    
            prevSecurity = (currSecurity > 0) ? currSecurity : prevSecurity;
        }

        return ans;
    }
}