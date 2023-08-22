class Solution {
    public int minOperations(String[] logs) {
        int pointer = 0;

        for (int i = 0; i < logs.length; i++) {
            if (pointer == 0 && logs[i].equals("../") || logs[i].equals("./")) {
                continue;
            }

            else if (logs[i].equals("../")) {
                pointer++;
            }

            else {
                pointer--;
            }
        }

        return Math.abs(0 + pointer);
    }
}