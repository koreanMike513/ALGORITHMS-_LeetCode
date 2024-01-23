class Solution {
    public int maxLength(List<String> arr) {
        Set<Character> set = new HashSet<>();

        return maxLength(arr, set, 0);
    }

    public int maxLength(List<String> arr, Set<Character> set, int idx) {
        if (idx == arr.size()) {
            return set.size();
        }
        
        String s = arr.get(idx);
        Set<Character> updated = new HashSet<>(set);
      
        for (int i = 0; i < s.length(); i++) {
            char wc = s.charAt(i);

            if (updated.contains(wc)) {
                return maxLength(arr, set, idx + 1);
            }

            updated.add(wc);
        }

        int res = 0;

        return res = Math.max(res, 
            Math.max(maxLength(arr, updated, idx + 1), maxLength(arr, set, idx + 1)));
    }
}