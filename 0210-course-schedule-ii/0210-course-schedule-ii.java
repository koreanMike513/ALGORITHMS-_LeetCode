class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int[] p : prerequisites) {
            list.get(p[0]).add(p[1]);
        }

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (dfs(list, ans, visited, i)) return new int[] {};
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    public boolean dfs(List<List<Integer>> list, List<Integer> ans, int[] visited, int current) {
        if (visited[current] == 1) return true;
        if (visited[current] == -1) return false;

        visited[current] = 1;

        for (int neighbour : list.get(current)) {
            if (dfs(list, ans, visited, neighbour)) return true;
        }

        visited[current] = -1;
        ans.add(current);
        return false;
    }
}