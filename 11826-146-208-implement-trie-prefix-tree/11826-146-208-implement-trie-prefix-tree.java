class Trie {
    static class Node {
        Map<Character, Node> characters = new HashMap<>();
        boolean isWord = false;
        char c;

        public Node() {

        }

        public Node (char c) {
            this.c = c;
        }
    }

    Node node = new Node();

    public Trie() {
        
    }
    
    public void insert(String word) {
        Node current = node;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!current.characters.containsKey(c))
                current.characters.put(c, new Node(c));
            
            current = current.characters.get(c);
        }

        current.isWord = true;
    }
    
    public boolean search(String word) {
        Node current = node;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!current.characters.containsKey(c))
                return false;
            
            current = current.characters.get(c);
        }

        return current.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node current = node;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (!current.characters.containsKey(c))
                return false;
            
            current = current.characters.get(c);
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */