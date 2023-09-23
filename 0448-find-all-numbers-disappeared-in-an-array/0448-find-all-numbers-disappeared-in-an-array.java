class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int j = 1; j <= nums.length; j++) {
            if (!set.contains(j)) {
                ans.add(j);
            }
        }

        return ans;
    }
}