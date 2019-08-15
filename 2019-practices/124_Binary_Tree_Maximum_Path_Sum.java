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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPath(root, 0);
        return max;
    }
    
    public int findMaxPath(TreeNode node, int curPath) {
        if(node == null) return curPath;
        
        int left = Math.max( findMaxPath(node.left, curPath), 0);
        int right = Math.max( findMaxPath(node.right, curPath), 0);
        max = Math.max( left + right + node.val , max);
        return Math.max(left, right) + node.val;
    }
}
