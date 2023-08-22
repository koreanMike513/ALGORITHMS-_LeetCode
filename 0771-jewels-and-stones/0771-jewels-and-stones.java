class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();

        for (int k = 0; k < jewels.length(); k++) { set.add(jewels.charAt(k)); }

        int count = 0;

        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) count++;
        }

        return count;
    }
}