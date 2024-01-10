class Solution {
    public long minimumSteps(String s) {
        int left = 0, right = s.length() - 1;
        long ans = 0;

        while (left <= right) {
            if (s.charAt(right) == '1') {
                right--;
            }

            else if (s.charAt(left) == '0') {
                left++;
            }

            else {
                ans += right - left; 
                right--; left++;
            }
        }

        return ans;
    }
}