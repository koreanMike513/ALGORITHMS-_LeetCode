class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length(), i = n1 - 1, j = n2 - 1, c = 0;
        
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int a = (i < 0) ? '0' : num1.charAt(i--);
            int b = (j < 0) ? '0' : num2.charAt(j--);
            int sum = (a - '0') + (b - '0') + c;

            c = sum / 10;
            int s = sum % 10;

            sb.append(s);
        }

        if (c > 0) sb.append(c);
        
        return sb.reverse().toString();
    }
}