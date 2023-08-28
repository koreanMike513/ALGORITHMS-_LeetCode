class Solution {
    public int[] getStrongest(int[] arr, int k) {
        if (k > arr.length || arr == null || arr.length == 0) return new int[] {};
        if (arr.length == 1 && k == 1) return arr; 

        Arrays.sort(arr);

        int i = 0, j = arr.length - 1, x = 0, m = arr[(arr.length - 1) / 2]; 
        int[] ans = new int[k];

        while (i <= j) {
            if (Math.abs(arr[i] - m) <= Math.abs(arr[j] - m)) {
                ans[x++] = arr[j];
                j--;
            }

            else if (Math.abs(arr[i] - m) > Math.abs(arr[j] - m)) {
                ans[x++] = arr[i];
                i++;
            }

            if (x == k) break;
        }

        return ans;
    }
}