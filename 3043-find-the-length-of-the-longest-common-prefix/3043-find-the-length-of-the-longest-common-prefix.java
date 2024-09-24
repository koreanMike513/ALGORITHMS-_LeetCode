class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;

    public TrieNode() {
        children = new HashMap<>();
    }
}

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = new TrieNode();
        int ans = 0;

        for (int n : arr2) {
            String number = new String(n + "");  
            insert(root, number);
        }

        for (int n : arr1) {
            String number = new String(n + "");  
            ans = Math.max(ans, search(root, number));
        } 

        return ans;
    }

    private void insert(TrieNode root, String number) {
        TrieNode current = root;

        for (char c : number.toCharArray()) {
            if (!current.children.containsKey(c))
                current.children.put(c, new TrieNode());
            
            current = current.children.get(c);
        }

        current.isEnd = true;
    }

    private int search(TrieNode root, String number) {
        TrieNode current = root;
        int length = 0;

        for (char c : number.toCharArray()) {
            if (!current.children.containsKey(c))
                return length;
            
            current = current.children.get(c);
            length++;
        }

        return length;
    }
}