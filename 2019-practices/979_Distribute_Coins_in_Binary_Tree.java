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
    public int count = 0;
    public int distributeCoins(TreeNode root) {
        balance(root);
        return count;
    }
    
    public int balance(TreeNode node) {
        if(node == null) return 0;
        
        int left = balance(node.left);
        int right = balance(node.right);
        count += Math.abs(left) + Math.abs(right);
        return left + right + node.val -1;
    }
}
