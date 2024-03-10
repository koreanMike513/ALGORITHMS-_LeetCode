class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int caps[] = new int[1001];

        for (int trip[] : trips){
            caps[trip[1]] += trip[0]; 
            caps[trip[2]] -= trip[0]; 
        }

        int carLoad = 0;

        for (int i = 0; i < 1001; i++){
            carLoad += caps[i];
            if (carLoad > capacity) 
                return false;
        }

        return true;
    }
}