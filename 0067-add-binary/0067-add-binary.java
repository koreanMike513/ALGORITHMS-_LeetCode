class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int indexA = a.length() - 1, indexB = b.length() - 1;
        int carry = 0;

        while (indexA >= 0 || indexB >= 0) {
            int oneCount = 0;
            oneCount += (indexA < 0) ? 0 : (int) a.charAt(indexA--) - '0';
            oneCount += (indexB < 0) ? 0 : (int) b.charAt(indexB--) - '0';
            oneCount += carry;

            sb.append(oneCount % 2);
            carry = oneCount / 2;            
        }

        if (carry > 0) sb.append(carry);
        
        return sb.reverse().toString();
    }
}