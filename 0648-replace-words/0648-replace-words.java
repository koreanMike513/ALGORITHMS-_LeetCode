class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder ans = new StringBuilder();

        for (String word : sentence.split("\s+")) {
            String t = word;
            int len = 101;

            for (String dict : dictionary) {
                if (word.startsWith(dict) && dict.length() < len) {
                    len = dict.length();
                    t = dict;
                }
            }

            ans.append(t).append(" ");
        }

        return ans.toString().substring(0, ans.length() - 1);
    }
}