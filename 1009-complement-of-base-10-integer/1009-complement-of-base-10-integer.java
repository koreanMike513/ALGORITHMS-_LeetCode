class Solution {
    public int bitwiseComplement(int n) {
        int ans = 0;

        if (n == 0)
            return 1;

        for (int i = 0; i < 31 && n > 0; i++) {
            int digit = ((n & 1) == 1) ? 0 : 1;
            ans = ans | digit << i;
            
            n = n >> 1;
        }

        return ans;
    }
}