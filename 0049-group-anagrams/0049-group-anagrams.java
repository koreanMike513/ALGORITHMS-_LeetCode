class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {

            int[] c = new int[26];

            for (int j = 0; j < str.length(); j++) {
                c[str.charAt(j) - 'a']++;
            }

            String key = Arrays.toString(c);

            if (!map.containsKey(key)) map.put(key, new ArrayList<>());

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}