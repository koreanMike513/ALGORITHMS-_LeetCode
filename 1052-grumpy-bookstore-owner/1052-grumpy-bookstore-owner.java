class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int totalSatisfied = 0;

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                totalSatisfied += customers[i];
            }
        }

        int maxAdditionalSatisfied = 0;
        int currentAdditionalSatisfied = 0;

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 1) {
                currentAdditionalSatisfied += customers[i];
            }

            if (i >= minutes && grumpy[i - minutes] == 1) {
                currentAdditionalSatisfied -= customers[i - minutes];
            }

            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, currentAdditionalSatisfied);
        }

        return totalSatisfied + maxAdditionalSatisfied;
    }
}
