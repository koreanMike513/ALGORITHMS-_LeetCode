class Solution {
    public int minCost(String colours, int[] neededTime) {
        int ans = 0;

        for (int i = 1; i < colours.length(); i++) {
            if (colours.charAt(i - 1) == colours.charAt(i)) {
                int min = Math.min(neededTime[i - 1], neededTime[i]);

                if (min == neededTime[i]) {
                    int temp = neededTime[i - 1];
                    neededTime[i - 1] = neededTime[i];
                    neededTime[i] = temp;
                }

                ans += min;
            }
        }

        return ans;
    }
}