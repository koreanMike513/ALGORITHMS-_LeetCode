class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sm = new int[26];
        int[] tm = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sm[s.charAt(i) - 'a']++;
        }

        for (int j = 0; j < t.length(); j++) {
            tm[t.charAt(j) - 'a']++;
        }


        return Arrays.equals(sm, tm);
    }
}