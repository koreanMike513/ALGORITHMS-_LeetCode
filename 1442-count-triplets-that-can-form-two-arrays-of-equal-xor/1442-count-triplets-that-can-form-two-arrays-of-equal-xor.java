class Solution {
    public int countTriplets(int[] arr) {
        int ans = 0;

        for(int i = 0;i < arr.length - 1; i++){
            int xor = arr[i];
            
            for (int k = i + 1; k < arr.length; k++){
                xor ^= arr[k];

                if (xor == 0)
                    ans += k - i;
            }
        }

        return ans;
    }
}