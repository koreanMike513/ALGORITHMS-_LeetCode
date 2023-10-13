class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences) {
            int t = sentence.split(" ").length;
            if (t > max) {
                max = t;
            }
        }

        return max;
    }
}