class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int[] list = new int[26];
        Stack<Character> stack = new Stack<>();

        for (int k = 0; k < s.length(); k++) {
            map.put(s.charAt(k), k);
            list[s.charAt(k) - 'a'] = 1;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (list[c - 'a'] == 0) continue;

            while (!stack.isEmpty() && c -'a' < stack.peek() - 'a' && i < map.get(stack.peek())) {   
                list[stack.pop() - 'a']++; 
            }

            stack.push(c);
            list[c - 'a']--; 
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}