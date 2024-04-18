class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        letterCasePermutation(list, s, "", 0);

        return list;
    }

    private void letterCasePermutation(List<String> list, String s, String c, int idx) {
        if (idx >= s.length()) {
            list.add(c);
            return;
        }

        if (Character.isLetter(s.charAt(idx))) {
            letterCasePermutation(list, s, c + Character.toLowerCase(s.charAt(idx)), idx + 1);
            letterCasePermutation(list, s, c + Character.toUpperCase(s.charAt(idx)), idx + 1);
        }
            
        else    
            letterCasePermutation(list, s, c + s.charAt(idx), idx + 1);
    }
}