class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int n = s.length(), m = spaces.length, spaceIdx = 0;

        for (int i = 0; i < n; i++) {
            if (spaceIdx < m && i == spaces[spaceIdx]) {
                sb.append(" ");
                spaceIdx++;
            }
            
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}