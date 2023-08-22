class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = arr1.length;
        int i = 0, j = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        while (i < arr1.length && j < arr2.length) {
            if (Math.abs(arr1[i] - arr2[j]) <= d) {
                i++;
                ans--;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            }
        }
        return ans;
    }
}