class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
                
        List<String> ans = new ArrayList<>();
        
        for (String dir : folder)
            if (ans.isEmpty() || !dir.startsWith(ans.get(ans.size() - 1) + "/"))
                ans.add(dir);
                
        return ans;
    }
}