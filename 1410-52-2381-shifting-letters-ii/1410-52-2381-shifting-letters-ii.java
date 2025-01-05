class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] delta = new int[n];
        StringBuilder sb = new StringBuilder();

        for (int[] shift : shifts) {
                int start = shift[0];
                int end = shift[1];
                int direction = (shift[2] == 1) ? 1 : -1;

                delta[start] += direction;

                if (end + 1 < n) 
                    delta[end + 1] -= direction;
        }

        int cumulativeShift = 0;
        
        for (int i = 0; i < n; i++) {
            cumulativeShift = (cumulativeShift + delta[i]) % 26;

            if (cumulativeShift < 0) 
                cumulativeShift += 26;

            char c = (char) (((s.charAt(i) - 'a' + cumulativeShift) % 26) + 'a');
            sb.append(c);
        }

        return sb.toString();
    }
}