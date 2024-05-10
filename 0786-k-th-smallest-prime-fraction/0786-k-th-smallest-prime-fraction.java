class Solution {
    class Number {
        int x, y;

        public Number(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class NumberComparator implements Comparator<Number> {
        @Override
        public int compare(Number n1, Number n2) {
            return (n1.x * n2.y) - (n1.y * n2.x);
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[2];

        PriorityQueue<Number> pq = new PriorityQueue<>(k, new NumberComparator());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pq.add(new Number(arr[i], arr[j]));
            }
        }

        while (k != 1) {
            pq.poll();
            k--;
        }

        Number number = pq.poll();
        ans[0] = number.x;
        ans[1] = number.y;

        return ans;
    }
}