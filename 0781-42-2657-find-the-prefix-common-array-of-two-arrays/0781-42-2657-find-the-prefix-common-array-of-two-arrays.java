class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length, c = 0;
        int[] freq = new int[51];
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            freq[A[i]]++;

            if (freq[A[i]] == 2)
                c++;

            freq[B[i]]++;
            
            if (freq[B[i]] == 2)
                c++;

            ans[i] = c;
        }

        return ans;
    }
}