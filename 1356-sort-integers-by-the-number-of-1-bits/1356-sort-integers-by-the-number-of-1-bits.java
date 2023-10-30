class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[][] bits = new int[n][2];

        for (int i = 0; i < n; i++) {
            int num = arr[i], count = 0;

            while (num != 0) {
                count += num & 1;
                num >>= 1;
            }

            bits[i] = new int[] { arr[i], count }; 
        }

        Arrays.sort(bits, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] == o2[1]) ? o1[0] - o2[0] : o1[1] - o2[1]; 
            }
        });

        for (int i = 0; i < n; i++) {
            arr[i] = bits[i][0];
        }

        return arr;
    }
}