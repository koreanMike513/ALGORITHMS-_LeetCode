class Solution {
    public int maxArea(int[] height) {

        int i = 0, j = height.length - 1;
        int max = 0;


        while (i <= j) {
            int volume = Math.min(height[j], height[i]) * (j - i);

            if (height[i] <= height[j]) {
                if (volume > max) max = volume;

                i++;
            }

            else {
                if (volume > max) max = volume;

                j--;
            }
        }

        return max;
    }
}