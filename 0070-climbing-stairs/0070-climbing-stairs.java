class Solution {
    public int climbStairs(int n) {

        Map<Integer, Integer> rep = new HashMap<>();
        rep.put(0, 1);
        rep.put(1, 1);

        int result = pivonacci(n, rep);

        return result;
    }

    public int pivonacci(int n, Map<Integer, Integer> rep) {
        if (rep.containsKey(n)) return rep.get(n);

        int sum = pivonacci(n - 1, rep) + pivonacci(n - 2, rep);

        rep.put(n, sum);

        return sum;
    }
}