class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0 || n < 0) return false;
        if (n == 1) return true;

        n = (n % 3 == 0) ? n /= 3 : 0; 

        return isPowerOfThree(n);
    }
}