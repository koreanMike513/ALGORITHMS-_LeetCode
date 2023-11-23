class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>());
        backtrack(list, new ArrayList<>(), nums, 0);

        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> t, int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            t.add(nums[i]);
            list.add(new ArrayList<>(t));
            backtrack(list, t, nums, i + 1);
            t.remove(t.size() - 1);
        }
    }
}