class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] sub: image) {

            if (sub.length % 2 != 0) {
                if (sub[sub.length / 2] == 0) sub[sub.length / 2] = 1; 
                else  sub[sub.length / 2] = 0; 
            }

            int j = sub.length - 1;

            for (int i = 0; i < j; i++) {
                if (sub[i] == 0) sub[i] = 1;
                else sub[i] = 0; 

                if (sub[j] == 0) sub[j] = 1;
                else sub[j] = 0;

                int temp = sub[i];
                sub[i] = sub[j];
                sub[j] = temp;

                j--; 
            }
        }

        return image;
    }
}