class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int second = 0;

        for(int i = 0; i < tickets.length; i++){
            queue.add(i);
        }
        while(!queue.isEmpty()){
            int index = queue.poll();
            tickets[index]--;
            second++;

            if(tickets[index] == 0 && index == k){
                return second;
            }

            if(tickets[index] > 0){
                queue.add(index);
            }
        }

        return second;
    }
}