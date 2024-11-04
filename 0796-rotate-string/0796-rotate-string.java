class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            sb.append(s.substring(i));
            sb.append(s.substring(0, i));

            if (sb.toString().equals(goal)) {
                return true;
            }
        }

        return s.equals(goal);
    }
}