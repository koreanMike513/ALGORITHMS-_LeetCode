class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            boolean crashed = false;

            while (!stack.isEmpty() && stack.peek() >= 0 && asteroids[i] < 0) {
                int sum = stack.peek() + asteroids[i];
                crashed = true;
                
                if (sum < 0) {
                    stack.pop();
                    crashed = false;
                }

                else if (sum == 0) {
                    stack.pop();
                    break;
                }

                else {
                    break;
                }
            }

            if (!crashed) stack.push(asteroids[i]);
        }

        int n = stack.size();
        int[] ans = new int[n];

        for (int j = 0; j < n; j++) {
            ans[n - 1 - j] = stack.pop();
        }

        return ans;
    }
}