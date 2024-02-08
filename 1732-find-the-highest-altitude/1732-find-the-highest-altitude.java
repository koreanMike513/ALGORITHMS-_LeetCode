class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length, ans = 0;
        int[] altitudes = new int[n + 1];
        altitudes[0] = 0;

        for (int i = 0; i < n; i++) {
            altitudes[i + 1] = gain[i] + altitudes[i];
            ans = Math.max(ans, altitudes[i + 1]);
        }
        
        return ans;
    }
}