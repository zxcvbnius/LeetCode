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
    int count = 0;
    int k, val;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        preorder(root);
        return val;
    }
    
    public void preorder(TreeNode node) {
        if(node == null) return;
        
        preorder(node.left);
        count++;
        if( count == k ) {
            val = node.val;
            return;
        }
        preorder(node.right);
        
        
    }
}
