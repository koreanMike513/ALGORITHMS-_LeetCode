class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        
        String reverse = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reverse;
        
        int[] prefixTable = buildPrefixTable(combined);
    
        int palindromeLength = prefixTable[prefixTable.length - 1];
        
        String suffixToPrepend = reverse.substring(0, s.length() - palindromeLength);
        
        return suffixToPrepend + s;
    }

    private int[] buildPrefixTable(String str) {
        int n = str.length();
        int[] prefixTable = new int[n];
        int j = 0; 
        
        for (int i = 1; i < n; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = prefixTable[j - 1];
            }
            
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            
            prefixTable[i] = j;
        }
        
        return prefixTable;
    }
}
