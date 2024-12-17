class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); 
        int[] alphabets = new int[26];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabets[i] > 0) 
                pq.add(new int[]{ i, alphabets[i] });
        }

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            char c = (char) (current[0] + 'a');
            int use = Math.min(current[1], repeatLimit);

            for (int k = 0; k < use; k++) {
                sb.append(c);
            }

            current[1] -= use;

            if (current[1] > 0 && !pq.isEmpty()) {
                int[] next = pq.poll();
                sb.append((char) (next[0] + 'a'));
                next[1]--;

                if (next[1] > 0)
                    pq.add(next);

                if (current[1] > 0)
                    pq.add(current);
            }                
        }

        return sb.toString();
    }
}