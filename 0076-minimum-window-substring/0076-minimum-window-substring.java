class Solution {
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0 || t.length() > s.length()) return "";

        String ans = ""; 
        int start = 0, end = 0, slide = t.length(), minLen = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();

        for (char c: t.toCharArray()) { map.put(c, map.getOrDefault(c, 0) + 1); }

        while (end < s.length()) {
            char character = s.charAt(end);

            if (slide > 0) {
                end++;
            }
            
            if (map.containsKey(character)) {
                int count = map.get(character);

                if (count > 0) {
                    slide -= 1;
                }

                map.put(character, count - 1);
            }

            while (slide == 0) {
                if (end - start < minLen) {
                    minLen = end - start;
                    ans = s.substring(start, end);
                }

                char temp = s.charAt(start);
                
                if (map.containsKey(temp)) {
                    int count = map.get(temp);
                    map.put(temp, count + 1);

                    if (map.get(temp) > 0) {
                        slide += 1;
                    }
                }

                start++;
            }
        }

        return ans;
    }
}