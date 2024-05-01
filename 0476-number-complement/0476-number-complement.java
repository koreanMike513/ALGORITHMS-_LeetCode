class Solution {
    public int findComplement(int num) {
        if (num == 0)
            return 1;

        int ans = 0;

        for (int i = 0; i < 31 && num > 0; i++) {
            int mask = ((num & 1) == 1) ? 0 : 1;
            ans |= mask << i;
            num = num >> 1;
        }

        return ans;
    }
}