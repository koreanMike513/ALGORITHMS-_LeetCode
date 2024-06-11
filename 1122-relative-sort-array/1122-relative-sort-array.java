class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length, idx = 0;
        int[] ans = new int[n];
        int[] map = new int[1001];

        for (int num : arr1) {
            map[num]++;
        }

        for (int num : arr2) {
            if (map[num] > 0) {
                while (map[num] > 0) {
                    ans[idx++] = num;
                    map[num]--;
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                while (map[i] > 0) {
                    ans[idx++] = i;
                    map[i]--;
                }
            }
        }

        return ans;
    }
}