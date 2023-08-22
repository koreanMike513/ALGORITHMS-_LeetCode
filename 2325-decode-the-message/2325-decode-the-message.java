class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        String ans = "";

        map.put(' ', ' ');
        int a = 97;

        for (int i = 0; i < key.length(); i++) {
            if (!map.containsKey(key.charAt(i))) {
                map.put(key.charAt(i), (char) a++);
            }
        }

        for (int j = 0; j < message.length(); j++) {
            ans += map.get(message.charAt(j));
        }

        return ans;
    }
}