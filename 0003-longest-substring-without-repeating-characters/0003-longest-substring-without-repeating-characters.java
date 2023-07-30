class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> c = new HashMap<>();

        int len = 0, prev = 0;

        for (int i = 0; i < s.length(); i++) {
          if (c.containsKey(s.charAt(i))) {

            prev = Math.max(prev, c.get(s.charAt(i)));
          }

          len = Math.max(len, i - prev + 1);

          c.put(s.charAt(i), i + 1);
        } 

        return len;
    }
}