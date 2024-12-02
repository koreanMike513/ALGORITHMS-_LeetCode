class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> zeroDegrees = new LinkedList<>();
        int[] degrees = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            degrees[prerequisite[0]]++;
        }

        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0)
                zeroDegrees.add(i);
        }

        if (zeroDegrees.isEmpty())
            return false;
        
        while (!zeroDegrees.isEmpty()) {
            int course = zeroDegrees.poll();

            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == course) {
                    degrees[prerequisite[0]]--;

                    if (degrees[prerequisite[0]] == 0)
                        zeroDegrees.add(prerequisite[0]);
                }
            }
        }

        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] != 0)
                return false;
        }

        return true;
    }   
}