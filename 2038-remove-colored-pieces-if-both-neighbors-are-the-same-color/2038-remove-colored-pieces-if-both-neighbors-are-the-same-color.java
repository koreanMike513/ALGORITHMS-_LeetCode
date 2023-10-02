class Solution {
    public boolean winnerOfGame(String colors) {
        int alice = 0, bob = 0, len = colors.length();

        for (int i = 0; i < len; i++) {
            char c = colors.charAt(i);

            if (c == 'A') {
                int start = i;
                while (i < len && colors.charAt(i) == c) { i++; };

                alice += Math.max(0, i - start - 2); 
            }
        }

        for (int j = 0; j < len; j++) {
            char c = colors.charAt(j);

            if (c == 'B') {
                int start = j;
                while (j < len && colors.charAt(j) == c) { j++; };

                bob += Math.max(0, j - start - 2); 
            }
        }

        return alice > bob;
    }
}