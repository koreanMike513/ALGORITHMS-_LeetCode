class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int condition = (n / 10 > 0) ? 9 : n % 10;

        for (int i = 1; i <= condition; i++) {
            lexicalOrder(ans, n, i);
        }

        return ans;
    }

    private void lexicalOrder(List<Integer> list, int n, int current) {
        if (current > n)
            return;
        
        list.add(current);

        for (int i = 0; i < 10; i++) {
            lexicalOrder(list, n, current * 10 + i);
        }
    }
}