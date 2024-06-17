class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> list = new ArrayList<>();
        backtrack(list, map, 0, new StringBuilder(), digits);

        return list;
    }

    public void backtrack(List<String> list, Map<Character, String> map, int index, StringBuilder sb, String digits) {
        if (index >= digits.length()) {
            if (sb.length() > 0)
                list.add(sb.toString());
            
            return;
        }

        for (char ch : map.get(digits.charAt(index)).toCharArray()) {
            sb.append(ch);
            backtrack(list, map, index + 1, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}