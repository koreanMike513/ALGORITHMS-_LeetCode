class Solution {
    Integer[][] dp = new Integer[501][501];
    public boolean stoneGame(int[] piles) {
        return recursion(0, piles.length - 1, piles) > 0;
    }
    
    public int recursion( int start, int end, int[] piles){
        if (start > end) {
            return 0;
        }

        if (dp[start][end] != null) {
            return dp[start][end];
        }

        int alex1 = (start - end) % 2 == 0 ? piles[start] : 0;  
        int alex2 = (start - end) % 2 == 0 ? piles[end] : 0; 
            
        int option1 = alex1 + recursion(start + 1, end, piles);
        int option2 = alex2 + recursion(start, end - 1, piles);
        
        return dp[start][end] = Math.max(option1,option2);
    }
}