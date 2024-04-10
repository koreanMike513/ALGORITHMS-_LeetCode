class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length, prev = 0;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = pref[i] ^ prev;
            prev = pref[i]; 
        }

        return ans;
    }
}