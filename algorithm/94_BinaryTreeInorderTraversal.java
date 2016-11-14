/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree [1,null,2,3],
 * Result. "Your runtime beats 35.84% of java submissions."
 */
 
 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// Sol1. Standard Inforder Traversal
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root != null) inorder(res, root);
        return res;
    }
    
    public void inorder(List<Integer> res, TreeNode node) {
        if(node.left != null)
            inorder(res, node.left);
        
        res.add(node.val);
        
        if(node.right != null)
            inorder(res, node.right);
    }   
}
