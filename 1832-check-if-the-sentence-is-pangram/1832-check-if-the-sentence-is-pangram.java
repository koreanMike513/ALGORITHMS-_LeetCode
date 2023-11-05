class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            }
        }

        return set.size() == 26;
    }
}