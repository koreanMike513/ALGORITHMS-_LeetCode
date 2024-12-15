class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])
        );

        for (int[] c : classes) {
            double gain = calculateGain(c[0], c[1]);
            pq.add(new double[]{ gain, (double) c[0], (double) c[1] });
        }

        while (extraStudents > 0) {
            double[] c = pq.poll();
            double gain = calculateGain((int) c[1] + 1, (int) c[2] + 1);
            pq.add(new double[]{ gain, c[1] + 1, c[2] + 1 });

            extraStudents--;
        }

        double totalPassRatio = 0.0;

        while (!pq.isEmpty()) {
            double[] c = pq.poll();
            totalPassRatio += (c[1] / c[2]);
        }

        return totalPassRatio / (double) classes.length;
    }

    private double calculateGain(int pass, int total) {
        return (((double) pass + 1) / ((double) total + 1)) - ((double) pass) / ((double) total);
    }
}