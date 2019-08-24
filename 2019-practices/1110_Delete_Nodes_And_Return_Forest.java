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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // there are two cases:
        // deleted node is leave
        // deleted node is root
        List<TreeNode> forest = new ArrayList<>();
        
        if( !isDeletedNode(root, to_delete) ) {
            forest.add(root);
            travel(root, null, to_delete, forest);
            
        } else {
            if( isLeaf(root) ) return forest;
            else {
                if(root.left != null) {
                    forest.add(root.left);
                    travel(root.left, root, to_delete, forest);
                }
                if(root.right != null) {
                    forest.add(root.right);
                    travel(root.right, root, to_delete, forest);
                }
            }
            
        }
        
        List<TreeNode> res = new ArrayList<>();
        for(TreeNode node : forest) {
            if(!isDeletedNode(node, to_delete) ) res.add( node );
        }
        
        return res;
    }
    
    public void travel(TreeNode node, TreeNode parent, int[] to_delete, List<TreeNode> forest) {
        boolean deleted = isDeletedNode(node, to_delete);
        
        if( deleted ) {
            if( !isLeaf(node) ) {
                if( node.left != null ) forest.add(node.left);
                if( node.right != null ) forest.add(node.right);   
            }
            
            if( parent != null ) {
                if( parent.left == node ) parent.left = null;
                if( parent.right == node ) parent.right = null;
            }   
        }
        
        if( node.left != null ) travel(node.left, node, to_delete, forest);
        if( node.right != null ) travel(node.right, node, to_delete, forest);
        
    }
    
    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    
    public boolean isDeletedNode(TreeNode node, int[] candidates) {
        for(int c : candidates) {
            if( node.val == c ) return true;
        }
        return false;
    }
}
