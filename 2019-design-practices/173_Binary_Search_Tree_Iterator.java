/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    
    TreeNode cur;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }
    
    /** @return the next smallest number */
    public int next() {
        while( cur != null ) {
            stack.push(cur);
            cur = cur.left;
        }
        TreeNode n = stack.pop();
        cur = n.right;
        return n.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if( cur == null && stack.isEmpty() ) return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
