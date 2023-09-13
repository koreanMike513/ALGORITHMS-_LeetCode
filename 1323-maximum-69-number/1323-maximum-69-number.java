class Solution {
    public int maximum69Number (int num) {
        StringBuilder ans = new StringBuilder(String.valueOf(num));
        int i = 0;
        
        while (i < ans.length()) {
            if (ans.charAt(i) == '6') {
                ans.setCharAt(i, '9');
                break;
            }

            i++;
        }

        return Integer.parseInt(ans.toString());
    }
}