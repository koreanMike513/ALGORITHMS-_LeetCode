class Solution {
    public void duplicateZeros(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
           if (arr[i] == 0) {
               int j = arr.length - 1;
               while (j > i + 1) {
                   arr[j] = arr[j - 1];
                   j--;
               }
               arr[j] = 0; i = j;
           }
        }
    }
}