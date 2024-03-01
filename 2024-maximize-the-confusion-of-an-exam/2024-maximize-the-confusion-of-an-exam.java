class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int countT = 0, countF = 0, res = 0;//self explanatory 
        
        for (int i = 0, j = 0; j < answerKey.length(); j++) {
            if (answerKey.charAt(j) == 'T') 
                countT++;
            else
                countF++;
            
            while (Math.min(countT, countF) > k) {
                if (answerKey.charAt(i++) == 'T') 
                    countT--;
                else
                    countF--;
            }
            
            res = Math.max(res, j - i + 1);
        }

        return res;
    }
}