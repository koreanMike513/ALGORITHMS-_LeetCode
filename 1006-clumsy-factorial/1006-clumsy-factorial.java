class Solution {
    public int clumsy(int n) {
        Stack<Integer> st = new Stack<>();
        Stack<Character> eq = new Stack<>();
        Map<Integer, Character> map = new HashMap<>();
        int sum = 0, k = 0, t = 1;

        map.put(0, '*'); 
        map.put(1, '/'); 
        map.put(2, '+'); 
        map.put(3, '-');

        for (int i = n; i >= 1; i--, t++) {
            if (t == 2) {
                eq.push(map.get(k++ % 4));
                t = 1;
            }

            if (!eq.isEmpty() && eq.peek() == '*') {
                st.push(st.pop() * i);
                eq.pop();
            }

            else if (!eq.isEmpty() && eq.peek() == '/') {
                st.push((int) Math.floor(st.pop() / i));
                eq.pop();
            }

            else {
                st.push(i);
            }
        }

        while (!st.isEmpty()) {
            if (!eq.isEmpty() && eq.pop() == '-') {
                sum -= st.pop();
            }

            else {
                sum += st.pop();
            }
        }

        return sum;
    }
}