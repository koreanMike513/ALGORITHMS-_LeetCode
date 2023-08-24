class Solution {
    public String smallestSubsequence(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        int[] alp = new int[26];

        for (int i = 0; i < s.length(); i++) { map.put(s.charAt(i), i); }

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            if (alp[c - 'a'] > 0) continue;

            while (!stack.isEmpty() && j < map.get(stack.peek()) && c < stack.peek()) {
                alp[stack.pop() -'a'] = 0;
            }

            stack.push(c);
            alp[c -'a'] = 1;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}