class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length(), startIdx = 0, targetIdx = 0;

        while (startIdx < n || targetIdx < n) {
            while (startIdx < n && start.charAt(startIdx) == '_') {
                startIdx++;
            }

            while (targetIdx < n && target.charAt(targetIdx) == '_') {
                targetIdx++;
            }   

            if (startIdx == n || targetIdx == n) {
                return startIdx == targetIdx;
            }

            if (start.charAt(startIdx) != target.charAt(targetIdx) || 
               (start.charAt(startIdx) == 'R' && startIdx > targetIdx) ||
               (start.charAt(startIdx) == 'L' && startIdx < targetIdx)
            )
                return false;

            startIdx++;
            targetIdx++;
        }

        return true;
    }
}