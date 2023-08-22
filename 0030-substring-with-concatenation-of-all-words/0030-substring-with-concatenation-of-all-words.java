class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> list = new ArrayList<>();
        int wsl = words.length;
        int wl = words[0].length();
        int slide = wsl * wl, start = 0, end = 0;
        Map<String, Integer> map = new HashMap<>();

        if (s == null || words == null || s.length() == 0 || words.length == 0) {
			return null;
		}

        for (String word: words) { map.put(word, map.getOrDefault(word, 0) + 1); }


        while (end <= s.length()) {

            if (end - start < slide) {
                end++;
            }

            else if (end - start == slide) {
                Map<String, Integer> map2 = new HashMap<>();
                String sub = s.substring(start, end);
                int idx = 0;

                while (idx < slide) {
                    String word = sub.substring(idx, idx + wl);
                    map2.put(word, map2.getOrDefault(word, 0) + 1);
                    idx += wl;
                }

                if (map.equals(map2)) list.add(start);

                start++; end++;
            }
        } 

        return list;
    }
}