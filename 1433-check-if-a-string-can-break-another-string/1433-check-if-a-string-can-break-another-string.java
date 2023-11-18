class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        int i = 0, k = 0;

        while (i < c1.length && (c1[i] -'0' >= c2[i] - '0')) { i++; }
        while (k < c1.length && (c1[k] -'0' <= c2[k] - '0')) { k++; }

        return (i == c1.length || k == c1.length);
    }
}