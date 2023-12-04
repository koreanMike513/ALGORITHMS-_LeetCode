class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";

        for (int i = 0; i < num.length(); i++) {
            int j = i;

            while (j < num.length() && num.charAt(i) == num.charAt(j)) {
                j++;
            } 

            if (j - i >= 3 && (ans.length() != 3 || ans.charAt(0) - '0' < num.charAt(i) - '0')) {
                ans = num.substring(i, i + 3);
                i = j - 1;
            }
        }

        return ans;
    }
}