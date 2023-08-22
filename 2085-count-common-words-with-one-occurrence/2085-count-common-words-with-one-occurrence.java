class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        int ans = 0;

        for (int i = 0; i < words1.length; i++) {
            map1.put(words1[i], map1.getOrDefault(words1[i], 0) + 1);
        }

        for (int j = 0; j < words2.length; j++) {
            map2.put(words2[j], map2.getOrDefault(words2[j], 0) + 1);
        }

        for (String word: map1.keySet()) {
            if (map2.containsKey(word)) {
                if ((map1.get(word) == map2.get(word)) && (map1.get(word) == 1))
                ans++;
            }
        }

        return ans;
    }
}