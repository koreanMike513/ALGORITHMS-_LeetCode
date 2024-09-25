class TrieNode {
    Map<Character, TrieNode> children;
    int words = 0;
    
    public TrieNode() {
        children = new HashMap<>();
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        int n = words.length;
        int[] ans = new int[n];

        for (String word : words) {
            insert(root, word);
        }

        for (int i = 0; i < n; i++) {
            ans[i] += search(root, words[i]);  
        }

        return ans;
    }

    private void insert(TrieNode root, String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c))
                current.children.put(c, new TrieNode());
            
            current = current.children.get(c);
            current.words++;
        }
    }

    private int search(TrieNode root, String word) {
        TrieNode current = root;
        int ans = 0;

        for (char c : word.toCharArray()) {
            current = current.children.get(c);
            ans += current.words;
        }

        return ans;
    }
}