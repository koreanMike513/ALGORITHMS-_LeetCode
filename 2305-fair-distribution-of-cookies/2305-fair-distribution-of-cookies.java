class Solution {
    public int distributeCookies(int[] cookies, int k) {
        return distributeCookies(cookies, new int[k], 0, k);
    }

    public int distributeCookies(int[] cookies, int[] children, int start, int k) {
        if (start == cookies.length) {
            int max = 0;

            for (int i = 0; i < children.length; i++) {
                max = Math.max(max, children[i]);
            }

            return max;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            children[i] += cookies[start];
            min = Math.min(min, distributeCookies(cookies, children, start + 1, k));
            children[i] -= cookies[start];
        }

        return min;
    }
}