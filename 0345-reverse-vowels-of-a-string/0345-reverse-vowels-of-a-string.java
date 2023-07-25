class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        char[] c = s.toCharArray();

        int i = 0, j = c.length - 1;

        while (i <= j) {
            while (i <= j && !vowels.contains(c[i])) i++;
            while (i <= j && !vowels.contains(c[j])) j--;


            if (i <= j && vowels.contains(c[i]) && vowels.contains(c[j])) {
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i++; j--;
            }
        }

        return new String(c);
    }
}