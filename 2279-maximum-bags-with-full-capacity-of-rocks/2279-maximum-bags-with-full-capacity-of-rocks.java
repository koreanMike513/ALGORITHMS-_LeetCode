class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int bags = 0;

        for (int i = 0; i < capacity.length; i++) {
            capacity[i] -= rocks[i];
        }

        Arrays.sort(capacity);

        for (int j = 0; j < capacity.length && additionalRocks > 0; j++) {
            if (additionalRocks >= capacity[j]) {
                bags++;
            }
            
            additionalRocks -= capacity[j];
        }

        return bags;
    }
}