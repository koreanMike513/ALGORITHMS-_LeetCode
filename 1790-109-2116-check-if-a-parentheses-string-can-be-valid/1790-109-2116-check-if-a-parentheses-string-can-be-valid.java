class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) {
            return false;
        }
        
        int balance = 0;
        int flexible = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (locked.charAt(i) == '0') {
                flexible++; 
            } else if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            
            if (balance + flexible < 0) {
                return false; 
            }
        }
        
        balance = 0;
        flexible = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (locked.charAt(i) == '0') {
                flexible++; 
            } else if (c == ')') {
                balance++;
            } else {
                balance--;
            }
            
            if (balance + flexible < 0) {
                return false; 
            }
        }
        
        return true;
    }
}
