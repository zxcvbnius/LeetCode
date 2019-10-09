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
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
        
    }
    public void inorder(TreeNode node) {
        if( node == null ) return;
        inorder(node.left);
        res.add(node.val);
        inorder(node.right);
    }
}
