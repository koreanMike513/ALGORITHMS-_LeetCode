class Solution {
    public int similarPairs(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, n = words.length;

        for (int i = 0; i < n; i++) {
            int key = 0;
            for (char c : words[i].toCharArray()) {
                key = (1 << (c - 'a')) | key;
            }

            int c = map.getOrDefault(key, 0);
            ans += c;
            map.put(key, c + 1);
        }

        return ans;
    }
}