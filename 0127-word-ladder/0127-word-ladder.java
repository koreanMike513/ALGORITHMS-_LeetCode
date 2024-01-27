class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> vis = new HashSet<>();
        Set<String> words = new HashSet<>(); 
        for (String word : wordList) { words.add(word); }

        Queue<String> qu = new LinkedList<>();
        char[] alphabets = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };


        qu.add(beginWord);

        int steps = 1;

        while (!qu.isEmpty()) {
            int size = qu.size();

            for (int i = 0; i < size; i++) {
                String current = qu.poll();

                if (current.equals(endWord)) {
                    return steps;
                }

                char[] c = current.toCharArray();

                for (int k = 0; k < c.length; k++) {
                    char old = c[k];
                    for (char letter : alphabets) {
                        c[k] = letter;
                        String next = new String(c);
                        
                        if (!vis.contains(next) && words.contains(next)) {
                            qu.add(next);
                            vis.add(next);
                        }
                    }

                    c[k] = old;
                }
            }

            steps++;
        }

        return 0;
    }
}