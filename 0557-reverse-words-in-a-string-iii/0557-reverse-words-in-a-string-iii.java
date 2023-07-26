class Solution {
    public String reverseWords(String s) {
        
        char[] c = s.toCharArray();

        int i = 0;

        while (i < c.length) {
            if (c[i] != ' ') {
                int j = i;

                while (j + 1 < c.length && c[j + 1] != ' ') j++;

                int end = j;

                for (int k = i; k <= j; k++) {
                    char temp = c[k];
                    c[k] = c[j];
                    c[j--] = temp; 
                }

                i = end; 
            }

            i++;
        }

        return new String(c);
    }
}