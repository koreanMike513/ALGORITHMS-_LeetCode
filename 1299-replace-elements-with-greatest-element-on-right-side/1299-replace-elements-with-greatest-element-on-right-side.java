class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length, greatest = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > greatest) {
                int t = greatest;
                greatest = arr[i];
                arr[i] = t; 
            }
            else {
                arr[i] = greatest; 
            }
        }

        arr[n - 1] = -1;

        return arr;
    }
}