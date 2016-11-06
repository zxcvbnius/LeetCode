/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Result. "Your runtime beats 14.67% of java submissions :("
 * Using DFS, time complexity : O(N) , space complexity : O(N)
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
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int max =  dfs(root, 1);
        return max;
    }
    public int dfs(TreeNode node, int depth) {
        if(node.left == null && node.right == null) return depth;
        else if(node.left == null) return dfs(node.right, depth + 1); 
        else if(node.right == null) return dfs(node.left, depth + 1);
        else {
            return Math.max( dfs(node.left, depth+1), dfs(node.right, depth + 1));
        }
    }
}
