class Solution {
    public int maximumCandies(int[] candies, long k) {
        int start = 1, end = Arrays.stream(candies).max().getAsInt(), ans = 0;

        while (start <= end) {
            int candy = (start + end) / 2;

            if (check(candies, k, candy)) {
                ans = candy;
                start = candy + 1;
            }  

            else {
                end = candy - 1;
            }
        }

        return ans;
    }

    private boolean check(int[] candies, long k, int candy) {
        if (candy == 0)
            return false;

        for (int c : candies) {
            k -= (long) (c / candy);
        }

        return k <= 0;
    }
}