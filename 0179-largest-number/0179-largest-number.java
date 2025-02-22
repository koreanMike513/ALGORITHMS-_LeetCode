class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;

                return order2.compareTo(order1); 
            }
        });

        if (arr[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();

        for (String num : arr) {
            sb.append(num);
        }

        return sb.toString();
    }
}