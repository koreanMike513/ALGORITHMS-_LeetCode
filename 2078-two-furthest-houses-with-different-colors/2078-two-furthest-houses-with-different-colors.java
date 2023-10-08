class Solution {
    public int maxDistance(int[] colors) {
        int left = 0, right = colors.length - 1, distance = 0;

        while (left <= right) {
            if (colors[left] != colors[right] && (right - left) > distance) {
                distance = right - left;
            }

            right--;
        }

        right = colors.length - 1;

        while (left <= right) {
            if (colors[left] != colors[right] && (right - left) > distance) {
                distance = right - left;
            }

            left++;
        }

        return distance;
    }
}