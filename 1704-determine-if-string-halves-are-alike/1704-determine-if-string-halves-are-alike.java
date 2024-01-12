class Solution {
    public boolean halvesAreAlike(String s) {
        int idx = 0, vowel1 = 0, vowel2 = 0;
        Set<Character> set = new HashSet<>();
        String vowel = "AEIOUaeiou";

        for (int i = 0; i < vowel.length(); i++) {
            set.add(vowel.charAt(i));
        }

        for (int i = idx; i < s.length() / 2; i++, idx++) {
            if (set.contains(s.charAt(idx))) {
                vowel1++;
            }
        }

        for (int i = idx; i < s.length(); i++, idx++) {
            if (set.contains(s.charAt(idx))) {
                vowel2++;
            }
        }
        
        return vowel1 == vowel2;
    }
}