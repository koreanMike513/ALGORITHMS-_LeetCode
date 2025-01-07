class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> ans = new HashSet<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && words[i].contains(words[j]))
                    ans.add(words[j]);
            }
        }

        return new ArrayList<>(ans);
    }
}