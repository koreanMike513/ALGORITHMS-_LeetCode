class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int ans = -1;

        for (int num : nums) {
            int sum = calculateDigits(num);

            if (!map.containsKey(sum))
                map.put(sum, new PriorityQueue<>((a, b) -> b - a));

            map.get(sum).add(num);
        }

        for (PriorityQueue<Integer> pq : map.values()) {
            if (pq.size() >= 2) 
                ans = Math.max(ans, pq.poll() + pq.poll());
        }

        return ans;
    }

    private int calculateDigits(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}