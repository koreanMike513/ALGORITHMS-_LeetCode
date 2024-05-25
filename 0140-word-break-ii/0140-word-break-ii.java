class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordDict); 

        wordBreakHelper(ans, new ArrayList<>(), s, dict, 0);

        return ans;
    }

    private void wordBreakHelper(List<String> ans, List<String> current, String s, Set<String> dict, int start) {
        if (start == s.length()) {
            ans.add(String.join(" ", current)); 
            return;
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);

            if (dict.contains(word)) {
                current.add(word); 
                wordBreakHelper(ans, current, s, dict, end); 
                current.remove(current.size() - 1); 
            }
        }
    }
}