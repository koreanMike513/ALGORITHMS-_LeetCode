class Solution {
    public String reversePrefix(String word, char ch) {
        char[] c = word.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == ch) {
                swap(i, c);
                break;
            }
        }

        return new String(c);
    }

    private void swap(int right, char[] c) {
        int left = 0;

        while (left <= right) {
            char character = c[left];
            c[left++] = c[right];
            c[right--] = character;
        }
    }
}