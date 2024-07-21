class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> qu = new LinkedList<>();
        int n = senate.length(), banR = 0, banD = 0, rCount = 0, dCount = 0;

        for (int i = 0; i < n; i++) {
            qu.add(senate.charAt(i));

            if (senate.charAt(i) == 'R')
                rCount++;
            else
                dCount++;
        } 

        while (rCount > 0 && dCount > 0) {
            Character player = qu.poll();

            if (player == 'R' && banR > 0) {
                banR--;
                rCount--;
            }

            else if (player == 'D' && banD > 0) {
                banD--;
                dCount--;
            }

            else if (player == 'R') {
                banD++;
                qu.add(player);
            }

            else if (player == 'D') {
                banR++;
                qu.add(player);
            }
        }

        return (qu.poll() == 'R') ? "Radiant" : "Dire";
    }
}