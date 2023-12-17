class Solution {
    public int convertTime(String current, String correct) {
        int totalCurrent = Integer.valueOf(current.substring(0, 2)) * 60 + Integer.valueOf(current.substring(3, 5));
        int totalCorrect = Integer.valueOf(correct.substring(0, 2)) * 60 + Integer.valueOf(correct.substring(3, 5));

        int ans = 0;

        while (totalCurrent < totalCorrect) {
            if (totalCorrect - totalCurrent >= 60) {
                totalCurrent += 60;
                ans++;
            }

            else if (totalCorrect - totalCurrent < 60 && totalCorrect - totalCurrent >= 15) {
                totalCurrent += 15;
                ans++;
            }
        
            else if (totalCorrect - totalCurrent < 15 && totalCorrect - totalCurrent >= 5) {
                totalCurrent += 5;
                ans++;
            }

            else {
                totalCurrent++;
                ans++;  
            }
        }


        return ans;
    }
}