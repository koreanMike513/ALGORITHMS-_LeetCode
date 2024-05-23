class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();

        findSubsequences(ans, new ArrayList<>(), nums, 0);

        return ans.stream().collect(Collectors.toList());
    }

    public void findSubsequences(Set<List<Integer>> ans, List<Integer> list, int[] nums, int idx) {
        if (idx >= nums.length) {
            if (list.size() > 1)
                ans.add(new ArrayList<>(list));

            return;
        } 
        
        if (list.size() > 0 && list.get(list.size() - 1) > nums[idx]) 
            findSubsequences(ans, list, nums, idx + 1);

        else {
            list.add(nums[idx]);
            findSubsequences(ans, list, nums, idx + 1);

            list.remove(list.size() - 1);
            findSubsequences(ans, list, nums, idx + 1);
        }
    }
}