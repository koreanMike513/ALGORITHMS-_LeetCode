class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        canVisitAllRooms(rooms, visited, 0);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    public void canVisitAllRooms(List<List<Integer>> rooms, boolean[] visited, int idx) {
        if (visited[idx]) {
            return;
        }

        List<Integer> keys = rooms.get(idx);

        visited[idx] = true;

        for (Integer key : keys) {
            canVisitAllRooms(rooms, visited, key);
        }
    }
}