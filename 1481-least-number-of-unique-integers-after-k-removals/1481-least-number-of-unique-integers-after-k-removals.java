class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int removed = 0;

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        for (Map.Entry<Integer, Integer> entry : list) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (k > 0) {
                if (k >= freq) {
                    k -= freq;
                    map.remove(num);
                } 
                else {
                    map.put(num, freq - k);
                    k = 0;
                }
            } 
            
            else {
                break;
            }
        }

        return map.size();
    }
}