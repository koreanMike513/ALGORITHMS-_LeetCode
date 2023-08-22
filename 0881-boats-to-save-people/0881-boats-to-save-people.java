class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        int i = 0, j = people.length - 1, count = 0;
        Arrays.sort(people);

        while (i <= j) {
            int sum = people[i] + people[j];

            if (sum <= limit) {
                count++; i++; j--;
            }
            else {
                count++; j--;
            }
        }

        return count;
    }
}