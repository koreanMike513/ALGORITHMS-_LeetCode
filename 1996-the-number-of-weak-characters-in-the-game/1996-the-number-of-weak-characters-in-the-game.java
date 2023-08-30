class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Stack<int[]> stack = new Stack<>();
        int count = 0;

        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }

                return o2[0] - o1[0]; 
            } 
        });

        stack.push(properties[0]);


        for (int i = 1; i < properties.length; i++) {
            if (properties[i][0] < stack.peek()[0] && properties[i][1] < stack.peek()[1]) {
                count++;
            }
            else {
                stack.push(properties[i]);
            }
        }

        return count;
    }
}