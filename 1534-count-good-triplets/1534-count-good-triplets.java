class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length, ans = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && 
                        Math.abs(arr[j] - arr[k]) <= b &&
                        Math.abs(arr[i] - arr[k]) <= c)
                        ans++;
                }
            }
        }

        return ans;
    }
}