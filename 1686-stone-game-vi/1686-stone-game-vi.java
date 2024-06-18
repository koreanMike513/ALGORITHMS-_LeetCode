class Pair {
    int sum, a, b;

    Pair(int a, int b) {
        sum = a + b;
        this.a = a;
        this.b = b;
    }
}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        return p2.sum - p1.sum;
    }
}

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        
        for (int i = 0;i < aliceValues.length; i++) {
            pq.offer(new Pair(aliceValues[i], bobValues[i]));
        }

        boolean turn = true;
        int aliceScore = 0, bobScore = 0;

        while (!pq.isEmpty()) {
            if (turn) {
                aliceScore += pq.poll().a;
            } 
            else {
                bobScore += pq.poll().b;
            }

            turn = !turn;
        }
        return Integer.compare(aliceScore, bobScore);
    }
}