class Solution {
    public int getSum(int a, int b) {
        int remainder = 0, ans = 0;

        for (int i = 0; i < 32; i++) {
            int bitA = ((a & 1) == 1) ? 1 : 0;
            int bitB = ((b & 1) == 1) ? 1 : 0;

            int bit = (bitA + bitB + remainder) % 2;
            remainder = (bitA + bitB + remainder) / 2;

            ans = ans | bit << i;
            a = a >> 1;
            b = b >> 1;
        }

        return ans;
    }
}