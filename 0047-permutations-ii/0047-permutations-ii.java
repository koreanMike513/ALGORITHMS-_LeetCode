class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(list, new ArrayList<Integer>(), visited, nums);

        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> t, boolean[] visited, int[] nums) {
        if (t.size() == nums.length) {
            list.add(new ArrayList<>(t));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1])) {
                continue;
            }
            
            visited[i] = true;
            t.add(nums[i]);
            backtrack(list, t, visited, nums);
            visited[i] = false;                
            t.remove(t.size() - 1);
        }
    }   
}