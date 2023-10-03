class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count0 = 0, count1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') count0++;
            else count1++;
        }

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < count1 - 1; j++) {
            sb.append('1');
        }

        for (int k = 0; k < count0; k++) {
            sb.append('0');
        }

        return sb.append('1').toString();
    }
}