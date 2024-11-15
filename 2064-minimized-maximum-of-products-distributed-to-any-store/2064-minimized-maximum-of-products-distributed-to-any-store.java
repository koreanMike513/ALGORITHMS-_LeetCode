class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int min = 0, max = Arrays.stream(quantities).max().getAsInt(), ans = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            
            if (canDistribute(n, quantities, mid)) {
                ans = mid;
                max = mid - 1;
            }

            else {
                min = mid + 1;
            }
        }

        return ans;
    }

    private boolean canDistribute(int n, int[] quantities, int average) {
        int groups = 0;

        for (int quantity : quantities) {
            groups += Math.ceil((double) quantity / (double) average);

            if (groups > n)
                return false;
        }

        return true;
    }
}