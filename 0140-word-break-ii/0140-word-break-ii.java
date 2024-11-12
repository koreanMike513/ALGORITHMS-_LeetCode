class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        Set<String> words = new HashSet<>(wordDict);

        findWords(s, list, words, new StringBuilder(), 0);

        return list;
    }

    private void findWords(
        String s, 
        List<String> list, 
        Set<String> words, 
        StringBuilder sb,
        int pos
        ) {
        if (pos >= s.length()) {
            list.add(new StringBuilder(sb).toString().trim());
            return;
        }

        for (int i = pos + 1; i <= s.length(); i++) {
            if (words.contains(s.substring(pos, i))) {
                StringBuilder t = new StringBuilder(sb);
                t.append(s.substring(pos, i)).append(" ");
                findWords(s, list, words, t, i);
            }
        }
    } 
}