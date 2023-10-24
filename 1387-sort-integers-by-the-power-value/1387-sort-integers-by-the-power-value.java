class Solution {
    
    static int[] power = new int[1000000];
    
    public int findPower (int num) {
        
        if (num == 1) {
            return 0;
        }
        else if (power[num] != 0) {
            return power[num];
        }
        
        power[num] = 1 + (num % 2 == 0 ? findPower (num / 2) : findPower (num * 3 + 1));
        return power[num];
    }
    
    public int getKth(int lo, int hi, int k) {
        
        int[][] powerList = new int[hi - lo + 1][2];
        
        for (int num = lo; num <= hi; num++) {
            powerList[num - lo][0] = num;
            powerList[num - lo][1] = findPower (num);
        }
        
        Arrays.sort (powerList, (pow1, pow2) -> pow1[1] - pow2[1]);
        
        return powerList[k - 1][0];
    }
}