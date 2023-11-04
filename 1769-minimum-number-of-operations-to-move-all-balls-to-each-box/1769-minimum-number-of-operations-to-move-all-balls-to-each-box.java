class Solution {
    public int[] minOperations(String boxes) {
        Set<Integer> set = new HashSet<>();
        int n = boxes.length();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                set.add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            int op = 0;
            for (Integer num : set) {
                op += Math.abs(num - i);
            }

            ans[i] = op;
        } 

        return ans;
    }
}