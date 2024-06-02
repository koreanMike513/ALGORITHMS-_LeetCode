class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>(){
            public int compare(double[] a, double[] b){
                double adiff = (a[0] + 1) / (a[1] + 1) - (a[0] / a[1]);                
                double bdiff = (b[0] + 1) / (b[1] + 1) - (b[0] / b[1]);
                
                if (adiff == bdiff) 
                    return 0;
                
                return adiff > bdiff ? -1 : 1;
            }
        });

        for (int[] c : classes) {
            pq.add(new double[] { c[0], c[1] });
        }

        for (int i = 0; i < extraStudents; i++) {
            double[] current = pq.poll();
            pq.add(new double[]{ current[0] + 1, current[1] + 1 });
        }

        double ans = 0;

        while (!pq.isEmpty()) {
            double[] current = pq.poll();
            ans += current[0] / current[1];
        }

        return ans / classes.length;
    }
}