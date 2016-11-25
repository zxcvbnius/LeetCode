/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 
 * Result. "Your runtime beats 15.89% of java submissions."
 */
public class Solution {
        
    int min = Integer.MAX_VALUE;    
    
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        getSum(root, 0);
        return min;
    }
    
    public void getSum(TreeNode node, int curDepth) {
        curDepth ++;
        if(node.left == null && node.right == null) {
            if(min > curDepth) min = curDepth;
        }
        if(node.left != null) getSum(node.left, curDepth);
        if(node.right != null) getSum(node.right, curDepth);
    }
}
