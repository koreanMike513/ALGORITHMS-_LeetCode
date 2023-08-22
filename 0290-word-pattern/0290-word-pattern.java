class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> pmap = new HashMap<>();
        Map<String, Character> wmap = new HashMap<>();
        String[] words = s.split(" ");

        if (words.length != pattern.length()) return false;

        for (int i = 0; i < words.length; i++) {
            char p = pattern.charAt(i);
            String word = words[i];

            if (!pmap.containsKey(p) && !wmap.containsKey(word)) {
                pmap.put(p, word);
                wmap.put(word, p);
            }

            else {
                if (pmap.containsKey(p) && wmap.containsKey(word)) {
                    if (!pmap.get(p).equals(word) || wmap.get(word) != p) {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }
}