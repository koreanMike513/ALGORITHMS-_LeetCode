class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < flights.length; i++) {
            if (!map.containsKey(flights[i][0])) {
                map.put(flights[i][0], new ArrayList<>());
            }

            map.get(flights[i][0]).add(new int[] { flights[i][1], flights[i][2] });
        }

        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[] { src, 0 });
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        int stops = 0;

        while (!qu.isEmpty() && stops <= k) {
            int size = qu.size();

            for (int i = 0; i < size; i++) {
                int[] current = qu.poll();

                if (!map.containsKey(current[0])) {
                    continue;
                }

                for (int[] neighbour : map.get(current[0])) {
                    int cost = neighbour[1], nextNeighbour = neighbour[0];
                    if (cost + current[1] >= minCost[nextNeighbour]) continue;

                    minCost[nextNeighbour] = cost + current[1];
                    qu.offer(new int[] { nextNeighbour, minCost[nextNeighbour] });
                }
            }

            stops++;
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}