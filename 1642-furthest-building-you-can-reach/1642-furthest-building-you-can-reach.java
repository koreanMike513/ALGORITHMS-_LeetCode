class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        Queue<Integer> ladderClimbs = new PriorityQueue<Integer>();

        for (int i = 1; i < n; i++) {
            int climb = heights[i] - heights[i - 1];
            if (climb <= 0)
                continue; 
                
            ladderClimbs.add(climb);
            if (ladderClimbs.size() <= ladders)
                continue; 
            
            if ((bricks -= ladderClimbs.poll()) < 0)
                return i - 1; 
        }
        
        return n - 1;
    }
}