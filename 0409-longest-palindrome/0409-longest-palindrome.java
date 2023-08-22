class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char w = s.charAt(i);
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        int len = 0;

        for (int n: map.values()) {
            len += (n % 2 == 0) ? n : n - 1;
        }

        return len < s.length() ? len + 1 : len;
    }
}