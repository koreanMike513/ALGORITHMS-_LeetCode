class Solution {
  public boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();

      for (int i = 0; i < s.length(); i++) {
          char word = s.charAt(i);

          if (stack.size() > 0) {
            char compare = stack.peek();
            if (word == ')' && compare == '(') {
                stack.pop();
            }
            else if (word == ']' && compare == '[') {
                stack.pop();
            }

            else if (word == '}' && compare == '{') {
                stack.pop();
            }
            else {
                stack.push(word);
            }
          }

          else {
              stack.push(word);
          }
        }

        return stack.size() == 0;
  } 
}

