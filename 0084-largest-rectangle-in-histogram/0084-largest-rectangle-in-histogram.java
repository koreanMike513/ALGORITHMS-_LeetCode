class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] info = new int[2];
        Stack<int[]> stack = new Stack<>();
        int maxVolume = 0;

        for (int i = 0; i < heights.length; i++) {
            int index = i;

            while (!stack.isEmpty() && stack.peek()[1] >= heights[i]) {
                maxVolume = Math.max(maxVolume, (i - stack.peek()[0]) * stack.peek()[1]);
                index = stack.peek()[0];
                stack.pop();
            }

            stack.push(new int[] { (stack.isEmpty()) ? 0 : index, heights[i] });
        }

        while (!stack.isEmpty()) {
            maxVolume = Math.max(maxVolume, (heights.length - stack.peek()[0]) * stack.peek()[1]);
            stack.pop();
        }

        return maxVolume;
    }
}