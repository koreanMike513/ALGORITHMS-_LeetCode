class Solution {
    public int findSpecialInteger(int[] arr) {
        int[] map = new int[100001];

        for (int i = 0; i < arr.length; i++) {
            map[arr[i]]++;

            if (map[arr[i]] > arr.length / 4) {
                return arr[i];
            }
        }

        return -1;
    }
}