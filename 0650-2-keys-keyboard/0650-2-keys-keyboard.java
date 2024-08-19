class Solution {
    int n;

    public int minSteps(int N) {
        n = N;
        return helper(1, 0, 0);
    }
    
    public int helper(int i, int copy, int pasteCount){
        if (i == n)
            return 0;

        if (i > n)
            return 10000;
        
        if (copy == 0) 
            return 1 + helper(i, 1, i);
        
   
        int op1 = 1 + helper(i + pasteCount, 1, pasteCount);
        int op2 = 1 + helper(i + pasteCount, 0, 0);
        
        return Math.min(op1, op2);
    }
       
}