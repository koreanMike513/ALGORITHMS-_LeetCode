class Solution {
    public int maximumValue(String[] strs) {
        int ans = 0;
        
        for (String str : strs) {
            boolean isStr = false;

            for (int i = 0; i < str.length(); i++) {
                int val = str.charAt(i) - '0';

                if (val > 9) 
                    isStr = true;
            }

            if (isStr) 
                ans = Math.max(ans, str.length());

            else 
                ans = Math.max(ans, Integer.parseInt(str));
        }

        return ans;
    }
}