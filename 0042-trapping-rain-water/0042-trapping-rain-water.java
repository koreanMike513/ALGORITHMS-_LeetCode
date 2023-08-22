class Solution {
    public int trap(int[] height) {

        if (height.length == 0 || height == null) return 0;

        int left = 0, right = height.length - 1, volume = 0, ml = 0, mr = 0;

        while (left <= right) {

            if (height[left] < height[right]) {

                if (ml < height[left]) {
                    ml = height[left];
                }
                else {
                    volume += ml - height[left];
                }
                left++;
            }
            else {
                if (mr < height[right]) {
                    mr = height[right];
                }
                else {
                    volume += mr - height[right];
                }
                right--;
            }
        }
        return volume;
    }
}