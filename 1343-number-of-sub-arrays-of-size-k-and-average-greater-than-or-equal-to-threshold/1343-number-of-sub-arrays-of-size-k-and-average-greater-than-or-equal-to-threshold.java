class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int count = 0, sum = 0, temp = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        temp = sum;

        if (temp / k >= threshold) count++;

        for (int j = k; j < arr.length; j++) {
            sum = sum - arr[j - k] + arr[j];
            temp = sum;

            if ((temp / k) >= threshold) count++;
        }

        return count;
    }
}