class Solution {
    public int numSteps(String s) {
        int count = 0, carry = 0, n = s.length() - 1;

        while (n > 0) {
            int bit = s.charAt(n) == '0' ? 0 : 1;

            if (bit + carry == 0) {
                carry = 0;
                count++;
            }

            else if (bit + carry == 2) {
                carry = 1;
                count++;
            }
            
            else {
                carry = 1;
                count += 2;
            }

            n--;
        }

        if (carry == 1) {
            count++;
        }

        return count;
    }
}