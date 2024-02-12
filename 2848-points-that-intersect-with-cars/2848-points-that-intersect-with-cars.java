class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        Collections.sort(nums, new Comparator<List<Integer>>() {

            @Override
            public int compare(List<Integer> n1, List<Integer> n2) {
                return n1.get(0) - n2.get(0);
            }
        });

        int ans = 0, current = 0;

        for (List<Integer> car : nums) {
            if (car.get(0) > current) {
                ans += car.get(1) - car.get(0) + 1;
            }
            else if (car.get(1) > current) {
                ans += car.get(1) - current;
            }

            current = Math.max(current, car.get(1));
        }

        return ans;
    }
}