class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int[] frequencies = new int[map.values().size()];
        int i = 0;

        for (int freq : map.values()) {
            frequencies[i++] = freq;
        }

        Arrays.sort(frequencies);

        int ans = 0, removed = 0, half = arr.length / 2, k = frequencies.length - 1;

        while (removed < half) {
            ans += 1;
            removed += frequencies[k--];
        }

        return ans;
    }
}