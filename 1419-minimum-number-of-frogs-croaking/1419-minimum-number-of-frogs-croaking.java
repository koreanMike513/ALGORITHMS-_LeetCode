class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int ans = -1, frogs = 0;
        int[] map = new int[26];
        
        for (char c : croakOfFrogs.toCharArray()) {
            map[c - 'a']++;

            if (c == 'c') {
                frogs++;
            }
            
            else {
                if (!isValidLetter(c, map)) 
                    return -1;

                if (c == 'k')
                    frogs--;
            }

            ans = Math.max(ans, frogs);
        }

        return (frogs == 0) ? ans : -1;
    }

    private boolean isValidLetter(char c, int[] map) {
        char prevChar;
        
        if (c == 'r') 
            prevChar = 'c';

        else if (c == 'o') 
            prevChar = 'r';

        else if (c == 'a')
            prevChar = 'o';
        
        else 
            prevChar = 'a';

        return map[c - 'a'] <= map[prevChar - 'a'];
    }
}