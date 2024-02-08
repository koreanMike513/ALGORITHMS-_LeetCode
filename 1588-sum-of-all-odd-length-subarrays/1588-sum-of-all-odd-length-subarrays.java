class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            int left = i + 1;
            int right = arr.length - i;
            int subArrays = left * right;
            int oddArrays = (subArrays % 2 == 0) ? subArrays / 2 : subArrays / 2 + 1;
            ans += arr[i] * oddArrays;
        }

        return ans;
    }
}