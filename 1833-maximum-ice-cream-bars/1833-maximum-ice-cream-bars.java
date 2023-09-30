class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxc = 0, count = 0;

        for (int i = 0; i < costs.length; i++) {
            if (maxc < costs[i]) {
                maxc = costs[i];
            }
        }

        int[] cc = new int[maxc + 1];

        for (int j = 0; j < costs.length; j++) {
            cc[costs[j]]++;
        }

        for (int k = 0; k <= maxc; k++) {
            if (coins <= 0) {
                break;
            }

            if (cc[k] == 0) {
                continue;
            }

            else if (cc[k] > 0) {
                for(int l = 0; l < cc[k]; l++) {
                    if (coins - k >= 0) {
                        coins -= k;
                        count++;
                    }

                    else {
                        break;
                    }
                }
            }
        }

        
        return count;
    }
}