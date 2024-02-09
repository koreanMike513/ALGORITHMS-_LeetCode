class Solution {
    public int pivotInteger(int n) {
        int sum = ((1 + n) * n) / 2, left = 0;

        for (int i = 1; i <= n; i++) {
            left += i;
            int right = sum - left + i;
            
            if (left == right) {
                return i;
            }
        }

        return -1;
    }
}