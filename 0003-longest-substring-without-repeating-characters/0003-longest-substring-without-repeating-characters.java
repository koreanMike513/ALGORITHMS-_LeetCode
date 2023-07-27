class Solution {
  public int lengthOfLongestSubstring(String s) {

      Map<Character, Integer> map = new HashMap<>();

      int max = 0, left = 0;
      
      for (int right = 0; right < s.length(); right++) {
          
        Character w = s.charAt(right);
          
        if (map.containsKey(w)) {
          
          left = Math.max(left, map.get(w));
        }

        max = Math.max(max, right - left + 1);

        map.put(w, right + 1);
    }

    return max;
  }
}