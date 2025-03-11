class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), start = 0, count = 0;
        int[] freq = new int[3];

        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;

            while (isFull(freq)) {
                count += n - i;
                freq[s.charAt(start++) - 'a']--;
            }
        }

        return count;
    }

    private boolean isFull(int[] freq) {
        for (int f : freq) {
            if (f == 0)
                return false;
        }

        return true;
    }
}