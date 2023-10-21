class Solution {
    public int findNonMinOrMax(int[] arr) {
        int min = arr[0], max = arr[0];
        for (var num : arr) {
            min = Math.min(min,num); 
            max = Math.max(max,num);
        }

        for (var num : arr) if (num != max && num != min) return num;
        
        return -1;
    }
}