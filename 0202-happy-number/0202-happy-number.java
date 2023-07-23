class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (true) {
            int sum = 0;
            int div = 10;
        
            while (n != 0) {
                sum += Math.pow((n % div), 2);
                n = n / div;
            }

            if (sum == 1) return true;
            else if (set.contains(sum)) return false;
            else {
                set.add(sum);
                n = sum;
            }

        }
    }
}