class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int x = 0, y = 0;

        set.add("0,0");

        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);

            if (c == 'N') {
                x++;
            }

            else if (c == 'E') {
                y++; 
            }

            else if (c == 'S') {
                x--;
            }

            else if (c == 'W'){
                y--;
            }

            String current = x + "," + y;
                
            if (set.contains(current)) {
                return true;
            }

            set.add(current);
        }

        return false;
    }
}