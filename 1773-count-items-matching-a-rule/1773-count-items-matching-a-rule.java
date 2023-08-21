class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {       int ans = 0;

        for (List<String> item: items) {
            
            if (ruleKey.equals("type")) {
                if (item.get(0).equals(ruleValue)) ans++;
            }

            else if (ruleKey.equals("color")) {
                if (item.get(1).equals(ruleValue)) ans++;
            }

            else {
                if (item.get(2).equals(ruleValue)) ans++;
            }
        }

        return ans;
    }
}