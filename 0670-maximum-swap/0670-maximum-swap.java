class Solution {
    public int maximumSwap(int num) {
        char[] numbers = Integer.toString(num).toCharArray();
        int n = numbers.length;
        
        int[] last = new int[10];

        for (int i = 0; i < n; i++) {
            last[numbers[i] - '0'] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int d = 9; d > numbers[i] - '0'; d--) {
                if (last[d] > i) {
                    char temp = numbers[i];

                    numbers[i] = numbers[last[d]];
                    numbers[last[d]] = temp;
                    
                    return Integer.parseInt(new String(numbers));
                }
            }
        }

        return num;
    }
}