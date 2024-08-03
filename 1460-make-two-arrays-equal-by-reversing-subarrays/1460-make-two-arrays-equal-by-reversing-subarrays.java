class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] set = new int[1001];

        for (int n : target) {
            set[n]++;
        }

        for (int n : arr) {
            set[n]--;
        }

        for (int n : set) {
            if (n != 0)
                return false;
        }

        return true;
    }
}