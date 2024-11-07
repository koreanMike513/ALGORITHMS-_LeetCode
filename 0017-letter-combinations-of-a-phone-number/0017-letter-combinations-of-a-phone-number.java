class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        map.put('2', List.of("a", "b", "c"));
        map.put('3', List.of("d", "e", "f"));
        map.put('4', List.of("g", "h", "i"));
        map.put('5', List.of("j", "k", "l"));
        map.put('6', List.of("m", "n", "o"));
        map.put('7', List.of("p", "q", "r", "s"));
        map.put('8', List.of("t", "u", "v"));
        map.put('9', List.of("w", "x", "y", "z"));

        letterCombinations(digits, map, list, new StringBuilder(), 0);

        return list;
    }

    private void letterCombinations(
        String digits, 
        Map<Character, List<String>> map, 
        List<String> list, 
        StringBuilder sb,
        int idx
        ) {
        if (idx >= digits.length()) {
            if (!sb.isEmpty())
                list.add(sb.toString());
                
            return;
        }

        for (String digit : map.get(digits.charAt(idx))) {
            sb.append(digit);
            letterCombinations(digits, map, list, sb, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
}