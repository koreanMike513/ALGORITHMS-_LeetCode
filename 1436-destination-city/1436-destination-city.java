class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();

        for (List<String> path: paths) {
            String city1 = path.get(0);
            String city2 = path.get(1);

            map.put(city1, city2);
        }

        String start = paths.get(0).get(0);

        while (true) {
            if (map.containsKey(start)) {
                String city = map.get(start);    
                start = city;
            }
            else {
                break;
            }
        }

        return start;
    }
}