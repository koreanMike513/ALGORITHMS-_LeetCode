class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k)
                list.add(nums.get(i));
        }

        return list.stream().reduce(0, (a, b) -> a + b);
    }
}