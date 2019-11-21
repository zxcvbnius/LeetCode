/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null ) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer( root );
        
        while( !queue.isEmpty() ) {
            int size = queue.size();
            TreeNode rightmost = null;
            while( size-- > 0 ) {
                TreeNode node = queue.poll();
                rightmost = node;
                if( node.left != null ) queue.offer( node.left );
                if( node.right != null ) queue.offer( node.right );
            }
            
            res.add( rightmost.val );
        }

        return res;
    }
}
