class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();
        
        if (p.length() > s.length()) { 
            return ans;
        }
        
        Map<Character, Integer> pMap = new HashMap<>(); 
        Map<Character, Integer> sMap = new HashMap<>();
        
        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (sMap.equals(pMap)) {
            ans.add(0);
        }

        int k = 0;

        for (int j = p.length(); j < s.length(); j++) {

            char acquire = s.charAt(j);

            sMap.put(acquire, sMap.getOrDefault(acquire, 0) + 1);

            char discard = s.charAt(k++);

            sMap.put(discard, sMap.get(discard) - 1);

            if (sMap.get(discard) == 0) {
                sMap.remove(discard);
            }


            if (sMap.equals(pMap)) {
                ans.add(k); 
            }
        }

        return ans;
    }
}