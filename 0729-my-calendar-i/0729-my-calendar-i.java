class TreeNode {
    TreeNode left;
    TreeNode right;
    int start;
    int end;

    public TreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class MyCalendar {
    TreeNode root;

    public MyCalendar() {
    }
    
    public boolean book(int start, int end) {
        if (root == null) {
            root = new TreeNode(start, end);
            return true;
        }

        return insert(root, start, end);
    }

    private boolean insert(TreeNode current, int start, int end) {        
        if (start >= current.end) {
            if (current.right == null) {
                current.right = new TreeNode(start, end);
                return true;
            }

            return insert(current.right, start, end);
        }

        if (end <= current.start) {
            if (current.left == null) {
                current.left = new TreeNode(start, end);
                return true;
            }

            return insert(current.left, start, end);
        }

        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */