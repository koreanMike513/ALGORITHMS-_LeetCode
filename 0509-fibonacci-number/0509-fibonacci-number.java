class Solution {
    public int fib(int n) {
        int[] res = new int[31];

        res[0] = 0;
        res[1] = 1;

        return Fibonacci(n, res);
    }

    public int Fibonacci(int n, int[] res) {
        if (n <= 1) return res[n];
        if (n > 1 && res[n] != 0) return res[n];

        int t = Fibonacci(n - 1, res) + Fibonacci(n - 2, res);

        res[n] = t;
        return t;
    }
}