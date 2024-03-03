public class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        long totalMinutes = 0; 
        long currentTravelTime = 0; 

        totalMinutes += garbage[0].length();
        
        List<Integer> lastGarbageIndices = new ArrayList<>(List.of(-1, -1, -1)); 

        for (int houseIndex = 1; houseIndex < garbage.length; houseIndex++) {
            totalMinutes += garbage[houseIndex].length();

            if (garbage[houseIndex].contains("M")) {
                lastGarbageIndices.set(0, houseIndex - 1);
            }
            if (garbage[houseIndex].contains("P")) {
                lastGarbageIndices.set(1, houseIndex - 1);
            }
            if (garbage[houseIndex].contains("G")) {
                lastGarbageIndices.set(2, houseIndex - 1);
            }
        }

        for (int travelIndex = 0; travelIndex < travel.length; travelIndex++) {
            currentTravelTime += travel[travelIndex];

            for (int truckIndex = 0; truckIndex < 3; truckIndex++) {
                if (lastGarbageIndices.get(truckIndex) == travelIndex) {
                    totalMinutes += currentTravelTime;
                }
            }
        }

        return (int) totalMinutes;
    }
}