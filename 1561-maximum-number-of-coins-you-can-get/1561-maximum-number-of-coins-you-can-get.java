class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int i = 0, j = piles.length - 2, score = 0;

        while (i < j) {
            score += piles[j];
            i++; j -= 2;
        }

        return score;
    }
}