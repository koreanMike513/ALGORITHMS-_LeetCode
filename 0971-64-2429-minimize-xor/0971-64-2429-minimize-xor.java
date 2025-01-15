class Solution {
    public int minimizeXor(int num1, int num2) {
        int ans = 0;
        int bits = Integer.bitCount(num2);
        int ones = Integer.bitCount(num1);
        int target = bits - ones;

        // System.out.println(target);
        // System.out.println("BITS: " + bits);

        if (target == 0)
            return num1;

        else if (target < 0) {
            for (char c : String.valueOf(Integer.toBinaryString(num1)).toCharArray()) {
                ans = ans << 1;

                if (c == '1' && bits > 0) {
                    ans++;
                    bits--;
                }
            }

            // System.out.println(ans);

            int t = ans;

            for (int i = 0; i < 32 && bits > 0; i++) {
                if ((t & 1) == 0) {
                    ans = ans | 1 << i;
                    bits--;
                }

                t = t >> 1;
            }
        }    

        else {
            for (int i = 0; i < 32; i++) {
                int digit = 0;

                if ((num1 & 1) == 1) {
                    digit = 1;
                }

                else if ((num1 & 1) == 0 && target > 0) {
                    digit = 1;
                    target--;
                }

                ans = ans | digit << i;
                num1 = num1 >> 1; 

                // System.out.println("ANS: " + ans);
            }
        }

        return ans;
    }
}