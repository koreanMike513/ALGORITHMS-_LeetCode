class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int current = 0;

        for (int num : nums) {
            current = (current << 1) | num;
            
            ans.add((current = (current % 5)) == 0 ? true: false);
        }

        return ans;
    }
}