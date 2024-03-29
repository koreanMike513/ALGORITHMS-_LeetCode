class Solution {
    public String restoreString(String s, int[] indices) {
        int len = s.length();
        char[] ans = new char[len];
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < len; i++) {
            ans[indices[i]] = s.charAt(i);
        }

        return sb.append(ans).toString();
    }
}