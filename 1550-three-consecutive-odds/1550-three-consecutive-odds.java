class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 1) {
                int start = i;
                while (i < n && arr[i] % 2 == 1) {
                    i++;
                }

                if (i - start > 2)
                    return true;
            }
        }

        return false;
    }
}