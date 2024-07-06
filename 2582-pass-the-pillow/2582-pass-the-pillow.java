class Solution {
    public int passThePillow(int n, int time) {
        int people = 1;

        while (time > 0) {
            while (time > 0 && people < n) {
                people++;
                time--;
            }
            
            if (time <= 0) break;
            
            while (time > 0 && people > 1) {
                people--;
                time--;
            }
        }

        return people;
    }
}