class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length(), count = 0;
        int[] arr = new int[26];

        for (int i = 0; i < n; i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);

            arr[a - 'a']++;
            arr[b - 'a']--;

            if (a != b) 
                count++;
        }

        for (int c : arr) {
            if (c != 0)
                return false;
        }

        return (count == 0 || count == 2);
    }
}