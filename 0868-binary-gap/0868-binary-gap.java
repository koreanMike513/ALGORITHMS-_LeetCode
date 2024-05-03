class Solution {
    public int binaryGap(int N) {
        int indexOne = -1, longestDistance = 0;
        for (int i = 0; i < 32; ++i) {
            if (((N >> i) & 1) == 1) { 
                if (indexOne != -1) 
                    longestDistance = Math.max(longestDistance, i - indexOne);
                indexOne = i;
            }
        }

        return longestDistance;
    }
}