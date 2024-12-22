class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        String ans = "";
        int n = s.length(), start = 0, min = n, slide = t.length();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) > 0)
                    slide -= 1;

                map.put(c, map.get(c) - 1);
            }

            while (slide == 0) {
                if (i - start < min) {
                    ans = s.substring(start, i + 1);
                    min = i - start;
                }
                
                char d = s.charAt(start);
                start++;

                if (map.containsKey(d)) {
                    if (map.get(d) == 0)
                        slide += 1;

                    map.put(d, map.get(d) + 1);
                }
            }
        }

        return ans;
    }
}