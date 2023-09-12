class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int nlen = name.length(), tlen = typed.length();

        if (tlen < nlen) return false;

        int k = 0;

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            char cc = typed.charAt(k);

            if (c != cc) {
                return false;
            }

            if (i < nlen - 1 && c == name.charAt(i + 1)) {
                k++;
                continue;
            }

            else {
                while (k < tlen - 1 && c == typed.charAt(k)) {
                    k++;
                }
            }
        }

        if (name.charAt(nlen - 1) != typed.charAt(k)) {
            return false;
        }

        return true;
    }
}