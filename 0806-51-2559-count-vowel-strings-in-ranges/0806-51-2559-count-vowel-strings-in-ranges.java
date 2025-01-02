class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> set = new HashSet<>();
        int n = queries.length, m = words.length, vowel = 0;
        int[] ans = new int[n];
        int[] vowels = new int[m];

        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');


        for (int i = 0; i < m; i++) {
            if (isVowel(words[i], set))
                vowel++;
            
            vowels[i] = vowel;
        }

        for (int i = 0; i < n; i++) {
            int max = 0, k = queries[i][0] - 1;
            int minus = (k == -1) ? 0 : vowels[k];

            ans[i] = vowels[queries[i][1]] - minus;
        }

        return ans;
    }

    private boolean isVowel(String word, Set<Character> set) {
        char start = word.charAt(0);
        char end = word.charAt(word.length() - 1);

        return set.contains(start) && set.contains(end);
    }
}