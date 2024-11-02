class Solution {
    public boolean isCircularSentence(String sentence) {
        List<String> words = Arrays.stream(sentence.split("\s")).collect(Collectors.toList());
        int circularCount = 0;

        words.add(words.get(0));

        for (int i = 1; i < words.size(); i++) {
            String prev = words.get(i - 1);
            String current = words.get(i);

            if (prev.charAt(prev.length() - 1) == current.charAt(0))
                circularCount++;
        }

        return circularCount == words.size() - 1;
    }
}