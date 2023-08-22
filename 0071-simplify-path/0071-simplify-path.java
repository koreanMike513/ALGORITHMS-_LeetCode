class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] ps = path.split("/");

        for (String p : ps) {
            if (!stack.isEmpty() && p.equals(".."))
                stack.pop();

            else if (!p.equals("") && !p.equals("..") && !p.equals(".")) 
                stack.push(p);
        }

        List<String> list = new ArrayList<>(stack);

        return "/" + String.join("/", list);
    }
}