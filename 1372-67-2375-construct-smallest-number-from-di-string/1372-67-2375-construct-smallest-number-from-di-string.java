class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int num = 1;

        stack.push(num);

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);

            if (c == 'I') {
                while (!stack.isEmpty()) {
                    ans.append(stack.pop());
                }

                num++;
                stack.push(num);
            }

            else {
                num++;
                stack.push(num);
            }
        }

        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }

        return ans.toString();
    }
}