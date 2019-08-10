/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// very slow...
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int depth = findMaxDepth(root);
        int lastCount = bfs(root, depth);
        
        int res = 0;
        for(int i = 0 ; i < depth ; i++) {
            res += 1 << i;
        }
        res += lastCount;
        
        return res;
    }
    
    public int bfs(TreeNode root, int depth) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add( root );

        while( depth > 0) {
            int size = stack.size();
            Stack<TreeNode> tmp = new Stack<>();
            while( size > 0 ) {
                TreeNode node = stack.pop();
                if(node.left != null) tmp.add( node.left );
                if(node.right != null) tmp.add( node.right );
                size--;
            }
            stack = tmp;
            depth--;
        }
        return stack.size();
    }
    
    public int findMaxDepth(TreeNode cur) {
        int depth = 0;
        while(cur.left != null) {
            cur = cur.left;
            depth++;
        }
        return depth;
    }
}
