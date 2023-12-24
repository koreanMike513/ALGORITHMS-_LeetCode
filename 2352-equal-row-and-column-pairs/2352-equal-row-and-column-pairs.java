class Solution {
    public int equalPairs(int[][] grid) {
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < grid[0].length; j++) {
                sb.append(grid[i][j] + ",");
            }

            sb.deleteCharAt(sb.length() - 1);
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }

        for (int j = 0; j < grid[0].length; j++) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < grid.length; i++) {
                sb.append(grid[i][j] + ",");
            }

            sb.deleteCharAt(sb.length() - 1);

            if (map.containsKey(sb.toString())) {
                ans += map.get(sb.toString());
            }
        }

        return ans;
    }
}