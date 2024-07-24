class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            StringBuilder sb = new StringBuilder();

            if (num == 0)
                sb.append(mapping[0]);

            while (num > 0) {
                int rm = num % 10;
                sb.append(mapping[rm]);
                num /= 10;
            }

            String t = sb.reverse().toString().equals("") ? "0" : sb.toString();
            list.add(new int[]{ nums[i], Integer.parseInt(t) });
        }

        Collections.sort(list, (a, b) -> a[1] - b[1]);

        return list.stream()
                .map((arr) -> arr[0])
                .mapToInt(Integer::intValue)
                .toArray();
    }
}