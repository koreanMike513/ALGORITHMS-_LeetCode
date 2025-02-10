class Solution {
    public String clearDigits(String s) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) && ans.length() != 0) 
                ans.setLength(ans.length() - 1);
             
            else 
                ans.append(s.charAt(i));
        }

        return ans.toString();
    }
}