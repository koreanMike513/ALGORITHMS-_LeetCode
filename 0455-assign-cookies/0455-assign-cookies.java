class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int i = g.length - 1, j = s.length - 1, count = 0;

        Arrays.sort(g); 
        Arrays.sort(s);

        while (i >= 0 && j >= 0) {
            if (g[i] <= s[j]) {
                i--; j--; count++;
            }

            else {
                i--;
            }
        }

        return count;
    }
}