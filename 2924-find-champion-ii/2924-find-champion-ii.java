class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] notChampions = new boolean[n];
        int champion = -1, size = 0;

        for (int[] edge : edges) {
            notChampions[edge[1]] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!notChampions[i]) {
                champion = i;
                size++;
            }
        }

        return size == 1 ? champion : -1;
    }
}