class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<String, Integer> dp = new HashMap<>();

        return shoppingOffers(dp, 0, price, special, needs);
    }

    private int shoppingOffers(Map<String, Integer> dp, int idx, List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (idx >= special.size())
            return calculateRest(needs, price);

        String key = getKey(needs, idx);

        if (dp.containsKey(key))
            return dp.get(key);

        int res = Integer.MAX_VALUE;

        if (!canGetSpecial(special.get(idx), needs))
            res = Math.min(res, shoppingOffers(dp, idx + 1, price, special, new ArrayList<>(needs)));

        else {
            res = Math.min(res, shoppingOffers(dp, idx + 1, price, special, new ArrayList<>(needs)));
            List<Integer> after = new ArrayList<>();

            for (int i = 0; i < needs.size(); i++) {
                after.add(needs.get(i) - special.get(idx).get(i));
            }

            res = Math.min(res, special.get(idx).get(needs.size()) + shoppingOffers(dp, idx, price, special, after));
            res = Math.min(res, special.get(idx).get(needs.size()) + shoppingOffers(dp, idx + 1, price, special, after));
        }

        dp.put(key, res);

        return dp.get(key);
    }

    private int calculateRest(List<Integer> needs, List<Integer> price) {
        int sum = 0;

        for (int i = 0; i < needs.size(); i++) {
            sum += needs.get(i) * price.get(i);
        }

        return sum;
    }

    private String getKey(List<Integer> needs, int idx) {
        StringBuilder sb = new StringBuilder();

        needs.forEach(n -> {
            sb.append(n).append(",");
        });
        
        sb.append(idx);

        return sb.toString();
    }

    private boolean canGetSpecial(List<Integer> special, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < special.get(i))
                return false;
        }

        return true;
    }
}