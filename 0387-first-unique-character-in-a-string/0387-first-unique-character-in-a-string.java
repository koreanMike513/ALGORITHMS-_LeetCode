class Solution {
    public int firstUniqChar(String s) {
        int[] list = new int[26];

        for (int i = 0; i < s.length(); i++) {
            list[s.charAt(i) - 'a'] = list[s.charAt(i) - 'a'] + 1;
        }

        for (int j = 0; j < s.length(); j++) {
            if (list[s.charAt(j) - 'a'] == 1) return j;
        }

        return -1;
    }
}