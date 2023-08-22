class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int i = 0, j = 0, cost = 0, count = 0; 

        while (j < s.length()) {
            while (j < s.length() && cost <= maxCost) {
                cost += Math.abs((s.charAt(j) - 'a') - (t.charAt(j) - 'a'));
                j++;
                if (cost <= maxCost) count = Math.max(count, j - i);
            }

            
            while (i <= j && cost > maxCost) {
                cost -= Math.abs((s.charAt(i) - 'a') - (t.charAt(i) - 'a'));
                i++;
            }
        }

        return count;
     }
}