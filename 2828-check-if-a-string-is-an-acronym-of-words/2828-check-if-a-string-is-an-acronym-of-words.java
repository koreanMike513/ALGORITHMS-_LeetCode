class Solution {
    public boolean isAcronym(List<String> words, String s) {
        char[] ca = s.toCharArray();
        int index = 0;

        for (String word : words) {
            if (index >= ca.length || ca[index++] != word.charAt(0)) {
                return false;
            }
        }

        return (index == ca.length);
    }
}