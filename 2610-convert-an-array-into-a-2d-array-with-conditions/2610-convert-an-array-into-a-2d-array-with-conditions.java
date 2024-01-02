class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] map = new int[nums.length];
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.fill(map, 1);

        while (true) {
            List<Integer> list = new ArrayList<>();
            boolean hasNum = false;

            for (int i = 0; i < nums.length; i++) {
                if (map[i] > 0 && !list.contains(nums[i])) {
                    list.add(nums[i]);
                    map[i]--;
                    hasNum = true;
                }
            }

            if (!hasNum) break;
            ans.add(list);
        }

        return ans;
    }
}