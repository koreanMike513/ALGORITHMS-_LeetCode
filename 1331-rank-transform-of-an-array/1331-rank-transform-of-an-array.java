class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 1, n = arr.length;
        int[] ans = new int[n], nums = arr.clone();

        Arrays.sort(nums);

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, idx++);
            }
        }

        for (int i = 0; i < n; i++) {
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }
}