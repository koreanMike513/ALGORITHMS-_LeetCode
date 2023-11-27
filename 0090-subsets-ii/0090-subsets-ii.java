class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        list.add(new ArrayList<Integer>());

        backtrack(list, new ArrayList<Integer>(), nums, 0);

        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> t, int[] nums, int start) {
        if (start >= nums.length) {
            return;
        }
        
        
        for (int i = start; i < nums.length; i++) {
            t.add(nums[i]);
            
            list.add(new ArrayList<>(t));
            
            backtrack(list, t, nums, i + 1);                
            t.remove(t.size() - 1);  

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) { i++; }
        }
    }
}