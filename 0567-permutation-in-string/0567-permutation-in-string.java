class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int j = 0; j <= s2.length() - s1.length(); j++) {
            Map<Character, Integer> s2Map = new HashMap<>();
            int k = j;
            
            while (k < j + s1.length()) {
                s2Map.put(s2.charAt(k), s2Map.getOrDefault(s2.charAt(k), 0) + 1);

                k++;
            }

            if (map.equals(s2Map)) return true;
        }

        return false;
    }
}