class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length(), mask = 0, ans = 0;
        int[] records = new int[32];
        Map<Character, Integer> even = new HashMap<>();

        even.put('a', 0);
        even.put('e', 1);
        even.put('i', 2);
        even.put('o', 3);
        even.put('u', 4);

        Arrays.fill(records, -2);
        records[0] = -1;

        for (int i = 0; i < n; i++) {
            if (even.containsKey(s.charAt(i)))
                mask ^= 1 << (int) (even.get(s.charAt(i)));
            
            if (records[mask] == -2)
                records[mask] = i;

            else 
                ans = Math.max(ans, i - records[mask]);
        }

        return ans;
    }
}