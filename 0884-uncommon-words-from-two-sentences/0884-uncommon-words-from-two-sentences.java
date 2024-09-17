class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> uc1 = new HashMap<>();
        Map<String, Integer> uc2 = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (String s : s1.split("\s+")) {
            uc1.put(s, uc1.getOrDefault(s, 0) + 1);
        }

        for (String s : s2.split("\s+")) {
            uc2.put(s, uc2.getOrDefault(s, 0) + 1);
        }

        for (String s : s1.split("\s+")) {
            if (!uc2.containsKey(s) && uc1.get(s) == 1)
                list.add(s);
        }

        for (String s : s2.split("\s+")) {
            if (!uc1.containsKey(s) && uc2.get(s) == 1)
                list.add(s);
        }

        return list.stream()
            .toArray(String[] ::new); 
    }
}