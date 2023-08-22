class Solution {
    public int countGoodSubstrings(String s) {

        Set<Character> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < s.length() - 2; i++) {

            for (int j = i; j < i + 3; j++) {
                set.add(s.charAt(j));
            }

            if (set.size() >= 3) count++;

            set.clear();
        }

        return count;
    }
}