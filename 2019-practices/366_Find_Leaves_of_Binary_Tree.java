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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leafLists = new ArrayList<>();
        
        if(root == null) return leafLists;

        while( true ) {
            List<Integer> leaves = new ArrayList<>();
            boolean res = isLeaves(root, leaves);
            leafLists.add( leaves );
            if(res) break;
            
        }
        return leafLists;
    }
    
    public boolean isLeaves(TreeNode node, List<Integer> leaves) {
        if(node.left == null && node.right == null) {
            leaves.add(node.val);
            return true;
        }
        
        if( node.left != null) {
            if( isLeaves(node.left, leaves) ) node.left = null;
        }
        
        if( node.right != null) {
            if( isLeaves(node.right, leaves) ) node.right = null;
        }
        
        return false;
    }
}
