class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length, sum = 0;
        int[] sums = new int[n];
        int[][] memo = new int[4][n];

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        sums[0] = sum;

        for (int i = k; i < n; i++) {
            sum = sum + nums[i] - nums[i - k];
            sums[i - k + 1] = sum;
        }

        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        System.out.println(Arrays.toString(sums));

        List<Integer> indices = new ArrayList<>();
        dp(memo, sums, k, 0, 3);
        dfs(memo, sums, k, 0, 3, indices);

        return indices.stream()
            .mapToInt(i -> i)
            .toArray();
    }

    private int dp(int[][] memo, int[] sums, int k, int idx, int rem) {
        if (rem == 0)
            return 0;

        if (idx >= sums.length)
            return (rem > 0) ? Integer.MIN_VALUE : 0; 

        if (memo[rem][idx] != -1)
            return memo[rem][idx];

        int include = sums[idx] + dp(memo, sums, k, idx + k, rem - 1);        
        int exclude = dp(memo, sums, k, idx + 1, rem);

        return memo[rem][idx] = Math.max(include, exclude);
    }

    private void dfs(int[][] memo, int[] sums, int k, int idx, int rem, List<Integer> indices) {
        if (idx >= sums.length)
            return;

        if (rem == 0)
            return;

        int include = sums[idx] + dp(memo, sums, k, idx + k, rem - 1);        
        int exclude = dp(memo, sums, k, idx + 1, rem);

        if (include >= exclude) {
            indices.add(idx);
            dfs(memo, sums, k, idx + k, rem - 1, indices);
        }

        else {
            dfs(memo, sums, k, idx + 1, rem, indices);
        }
    }
}
