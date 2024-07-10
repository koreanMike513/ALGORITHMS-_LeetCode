class Solution {
    public double averageWaitingTime(int[][] customers) {
        double total = 0.0;
        int time = 0, n = customers.length;

        for (int i = 0; i < n; i++) {
            time = customers[i][1] + Math.max(time, customers[i][0]);
            total += time - customers[i][0];
        }

        return total / (double) n;
    }
}