class Solution {
    private int c;

    public String getHappyString(int n, int k) {
        String[] letters = new String[]{ "a", "b", "c" };
        c = k;

        return getHappyString(letters, new StringBuilder(), n, -1);
    }

    private String getHappyString(String[] letters, StringBuilder sb, int n, int prev) {
        if (sb.length() == n) {
            if (--c == 0)
                return sb.toString();
            
            return "";
        }

        String res = "";

        for (int i = 0; i < 3; i++) {
            if (i != prev) {
                sb.append(letters[i]);
                String t = getHappyString(letters, sb, n, i);

                if (t.length() > 0)
                    res = t;
                    
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return res;
    }
}