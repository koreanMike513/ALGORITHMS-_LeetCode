class Solution {
    public int minPartitions(String n) {
        int max = 0;
        
        for (char c : n.toCharArray()) {
            int num = c - '0';
            if (max < num) {
                max = num;
            }
        }

        return max;
    }
}