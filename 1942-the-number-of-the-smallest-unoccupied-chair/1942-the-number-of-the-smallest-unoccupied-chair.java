class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length, m = 3;
        int[][] timeAndFriends = new int[n][m];
        int[] chairs = new int[n];

        for (int i = 0; i < n; i++) {
            timeAndFriends[i] = new int[] { times[i][0], times[i][1], i };
        }

        Arrays.sort(timeAndFriends, (a, b) -> a[0] - b[0]);

        for (int[] timeAndFriend : timeAndFriends) {
            for (int i = 0; i < n; i++) {  
                if (chairs[i] <= timeAndFriend[0]) {
                    if (timeAndFriend[2] == targetFriend) {
                        return i; 
                    }

                    chairs[i] = timeAndFriend[1];
                    break;
                }
            }
        }

        return -1;
    }
}