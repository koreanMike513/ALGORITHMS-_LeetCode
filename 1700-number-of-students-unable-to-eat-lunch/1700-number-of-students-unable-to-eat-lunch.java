class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        int i = 0, notserved = 0;

        for (int student: students) { queue.add(student); }
      
        while (i < sandwiches.length && notserved < queue.size()) {
            if (queue.peek() == sandwiches[i]) {
                queue.poll();
                notserved = 0;
                i++; 
            }

            else {
                int t = queue.poll();
                queue.add(t);
                notserved++;
            }
        }

         return queue.size();
    }
}