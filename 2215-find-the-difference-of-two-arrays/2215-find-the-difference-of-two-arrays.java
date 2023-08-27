class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int j = 0; j < nums1.length; j++) {
            set1.add(nums1[j]);
        }

        for (int j = 0; j < nums2.length; j++) {
            set2.add(nums2[j]);
        }


        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            if (!set2.contains(nums1[i])) {
                set2.add(nums1[i]);
                list1.add(nums1[i]);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (!set1.contains(nums2[i])) {
                set1.add(nums2[i]);
                list2.add(nums2[i]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        ans.add(list1);
        ans.add(list2);

        return ans;
    }
}