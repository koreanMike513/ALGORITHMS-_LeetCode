class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb;
        int n = nums.length;


        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            int k = i + 1;

            while (k < n && nums[k - 1] + 1 == nums[k]) {
                k++;
            }

            k--;
            sb.append(nums[i]);

            if (nums[i] != nums[k]) {
                sb.append("->");
                sb.append(nums[k]);
            }

            i = k;
            ans.add(sb.toString());
        }

        return ans;
    }
}