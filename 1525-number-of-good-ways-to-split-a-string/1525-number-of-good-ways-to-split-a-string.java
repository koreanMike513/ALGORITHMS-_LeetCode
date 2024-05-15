class Solution {
    private int bitCount(int n) {
        return (n == 0) ? 0 : bitCount(n >> 1) + (n & 1);
    }

    public int numSplits(String s) {
        int n = s.length(), ans = 0;
        int[] al = new int[n];
        int[] ar = new int[n];

        al[0] = 1 << (int) (s.charAt(0) - 'a'); 
        ar[n - 1] = 1 << (int) (s.charAt(n - 1) - 'a'); 

        for (int i = 1; i < n - 1; i++) {
            al[i] = al[i - 1] | 1 << (int) (s.charAt(i) - 'a');
            ar[n - 1 - i] = ar[n - i] | 1 << (int) (s.charAt(n - 1 - i) - 'a');
        }

        for (int i = 0; i < n - 1; i++) {
            if (bitCount(al[i]) == bitCount(ar[i + 1]))
                ans++;
        }

        return ans;
    }
}