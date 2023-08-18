class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }

            stack.push(nums2[i]);
        }

        for (int j = 0; j < nums1.length; j++) {
            nums1[j] = map.getOrDefault(nums1[j], -1);
        }

        return nums1;
    }
}