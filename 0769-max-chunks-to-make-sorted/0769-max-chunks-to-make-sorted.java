class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, chunks = 0, target = -1;
        boolean[] numbers = new boolean[n];

        for (int i = 0; i < n; i++) {
            numbers[arr[i]] = true;
            target = Math.max(target, arr[i]);

            if (target == i && hasAllElements(i, numbers)) {
                chunks++; 
                target = -1;
            } 
        }

        return chunks;
    }

    private boolean hasAllElements(int i, boolean[] numbers) {
        for (int k = 0; k <= i; k++) {
            if (!numbers[k])
                return false;
        }

        return true;
    }
}