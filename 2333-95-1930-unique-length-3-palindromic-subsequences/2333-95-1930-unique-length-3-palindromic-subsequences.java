class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length(), ans = 0;
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, - 1);

        for (int i = 0; i < n; i++) {
            int pos = s.charAt(i) - 'a';
            if (first[pos] == -1)
                first[pos] = i;
            
            last[pos] = i;
        } 

        for (int i = 0; i < 26; i++) {
            if (first[i] == -1)
                continue;

            Set<Character> between = new HashSet<>();
            for (int j = first[i] + 1; j < last[i]; j++) {
                between.add(s.charAt(j));
            }

            ans += between.size();
        }

        return ans;
    }
}