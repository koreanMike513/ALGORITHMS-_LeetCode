class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        List<String> ans = new ArrayList<>();

        if (words == null || words.length == 0) return ans;
        
        ans.add(words[0]);

        for (int i = 1; i < words.length; i++) {

            int[] w1 = new int[26];
            int[] w2 = new int[26];

            char[] c1 = words[i - 1].toCharArray();  
            char[] c2 = words[i].toCharArray();

            for (char c: c1) { w1[c - 'a']++; }
            for (char c: c2) { w2[c - 'a']++; }

            if (!Arrays.equals(w1, w2)) ans.add(words[i]);
        }

        return ans;
    }
}