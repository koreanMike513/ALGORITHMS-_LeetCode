class Solution {
    public int getLucky(String s, int k) {
        String ans = convert(s);

        while (k > 0) {
            ans = calculate(ans);
            k--;
        }

        return ans.equals("") ? -1: Integer.parseInt(ans);
    }  

    private String convert(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }

        return sb.toString();
    }

    private String calculate(String s) {
        int sum = 0;

        for (char c : s.toCharArray()) {
            sum += c - '0';
        }

        return sum + "";
    }
}