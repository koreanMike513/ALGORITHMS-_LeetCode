class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            var reverse = new StringBuilder(words[i]).reverse().toString();

            if (set.contains(reverse)) {
                count++;
            }
            set.add(words[i]);
        }

        return count;
    }
}