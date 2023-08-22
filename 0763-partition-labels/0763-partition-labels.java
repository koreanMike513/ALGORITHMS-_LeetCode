class Solution {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> list = new ArrayList<>();
        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i; 
        }

        int start = 0, end = 0;

        for (int j = 0; j < s.length(); j++) {
            end = Math.max(end, last[s.charAt(j) - 'a']);

            if (j == end) {
                list.add(end - start + 1);

                start = j + 1;
            }
        }

        return list;
    }
}