class Solution {
    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        int[] map = new int[26];
        
        for (int i = 0; i < chars.length(); i++) {
            map[chars.charAt(i) - 'a']++;
        }

        for (String word : words) {
            char[] ch = word.toCharArray();
            int[] t = Arrays.copyOf(map, map.length);
            boolean isGood = true;

            for (int i = 0; i < ch.length; i++) {
                if (--t[ch[i] - 'a'] < 0) {
                    isGood = false;
                    break;
                }
            }

            if (isGood) {
                ans += word.length();
            }
        }

        return ans;
    }
}