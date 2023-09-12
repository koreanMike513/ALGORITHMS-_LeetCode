class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        int ans = 0;

        for (char c : allowed.toCharArray()) { set.add(c); }

        for (String word : words) {
            boolean isConsistent = true;

            for (int i = 0; i < word.length(); i++) {
                if (!set.contains(word.charAt(i))) {
                    isConsistent = false;
                    break;
                }
            }

            if (isConsistent) {
                ans++;
            }
        }

        return ans;
    }
}