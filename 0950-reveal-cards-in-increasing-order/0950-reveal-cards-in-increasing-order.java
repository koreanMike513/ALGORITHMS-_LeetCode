class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[deck.length];

        for (int k = 0; k < deck.length; k++) { queue.add(k); }

        Arrays.sort(deck);
        
        for (int i = 0; i < deck.length; i++) {
            ans[queue.poll()] = deck[i];
            queue.add(queue.poll());
        }

        return ans;
    }
}