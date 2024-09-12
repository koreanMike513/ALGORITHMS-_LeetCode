class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int prev = map.get(s.charAt(0)), ans = prev;

        for (int i = 1; i < s.length(); i++) {
            int current = map.get(s.charAt(i));

            if (prev < current)
                ans -= prev * 2;

            ans += current;
            prev = current;
        }

        return ans;
    }
}