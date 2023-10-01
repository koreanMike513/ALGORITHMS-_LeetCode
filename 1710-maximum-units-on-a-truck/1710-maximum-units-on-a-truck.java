class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int maxWeight = 0;
        Arrays.sort(boxTypes, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (int i = 0; i < boxTypes.length; i++) {
            while (truckSize > 0 && boxTypes[i][0] > 0) {
                maxWeight += boxTypes[i][1];
                boxTypes[i][0]--;
                truckSize--;
            }
        }

        return maxWeight;
    }
}