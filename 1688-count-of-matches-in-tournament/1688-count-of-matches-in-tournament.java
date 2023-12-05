class Solution {
    public int numberOfMatches(int n) {
        if (n < 2) {
            return 0;
        }

        return findMatches(n);
    }

    public int findMatches(int n) {
        int matches = 0;
        matches += (n / 2);

        if (n == 2) {
            return matches;
        }

        n += (n % 2 == 0) ? 0 : 1;

        return matches + findMatches(n / 2);
    }
}