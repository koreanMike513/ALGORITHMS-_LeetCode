class Solution {
    public int takeCharacters(String s, int k) {
        int[] total = new int[3], current = new int[3];
        int n = s.length(), start = 0, len = 0;

        for (char c : s.toCharArray()) {
            total[c - 'a']++;
        }

        if (total[0] < k || total[1] < k || total[2] < k)
            return -1;
        
        if (k == 0)
            return 0;

        for (int end = 0; end < n; end++) {
            char c = s.charAt(end);
            current[c - 'a']++;

            while (   
                total[0] - current[0] < k ||
                total[1] - current[1] < k ||
                total[2] - current[2] < k 
            ) {
                if (start > end)
                    break;

                char remove = s.charAt(start);
                current[remove - 'a']--;
                start++;
            }

            len = Math.max(len, end - start + 1);
        }

        return n - len;
    }
}