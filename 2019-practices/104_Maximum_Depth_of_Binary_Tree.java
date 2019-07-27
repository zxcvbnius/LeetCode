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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int max_dep = find_depth(root, 1);
        return max_dep;
    }
    
    public int find_depth(TreeNode node, int current_dep) {
        if(node == null) return current_dep;
        // leaf
        if(node.left == null && node.right == null) return current_dep;
        
        int left_dep = find_depth(node.left, current_dep + 1);
        int right_dep = find_depth(node.right, current_dep + 1);

        return Math.max(left_dep, right_dep);
    }
}
