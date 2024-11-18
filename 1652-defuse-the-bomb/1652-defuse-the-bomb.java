class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length, start = 1, end = k, sum = 0;
        int[] ans = new int[n];

        if (k == 0)
            return ans;

        if (k < 0) {
            start = n - Math.abs(k);
            end = n - 1;
        }
        
        for (int i = start; i <= end; i++) {
            sum += code[i];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = sum;
            sum += code[(end + 1) % n];
            sum -= code[(start) % n];
            start++;
            end++;
        }

        return ans;
    }
}