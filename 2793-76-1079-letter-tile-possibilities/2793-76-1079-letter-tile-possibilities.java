class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> all = new HashSet<>();

        numTilePossibilities(all, tiles, new StringBuilder(), new boolean[tiles.length()]);

        return all.size() - 1;
    }

    private void numTilePossibilities(
        Set<String> all, 
        String tiles, 
        StringBuilder current,
        boolean[] used
        ) {
            
        all.add(current.toString());

        for (int i = 0; i < tiles.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                current.append(tiles.charAt(i));
                numTilePossibilities(all, tiles, current, used);
                used[i] = false;
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}