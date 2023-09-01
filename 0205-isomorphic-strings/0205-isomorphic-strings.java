class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] smap = new int[256];
        int[] tmap = new int[256];

        for (int i = 0; i < t.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (smap[sc] != tmap[tc] ) {
                return false;
            }

            smap[sc] = i + 1;
            tmap[tc] = i + 1;
        }

        return true;
    }
}