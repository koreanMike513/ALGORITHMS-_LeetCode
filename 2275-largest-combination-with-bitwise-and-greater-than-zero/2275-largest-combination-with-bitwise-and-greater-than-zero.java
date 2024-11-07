class Solution {
    public int largestCombination(int[] candidates) {
        int[] ones = new int[24];
        int ans = 0;

        for (int candidate : candidates) {
            int idx = 0;
            while (candidate > 0) {
                if ((candidate & 1) == 1)
                    ones[idx]++;

                candidate = candidate >> 1;
                idx++;
            }
        }

        for (int i = 0; i < 24; i++) {
            ans = Math.max(ans, ones[i]);
        }
        
        return ans;
    }
}