/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 * 
 * Example:
 * 
 * Input:
 * 
 *    1
 *     \
 *      3
 *     /
 *    2
 * 
 * Output:
 * 1
 * 
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 */
 
 // Result. "Your runtime beats 26.74% of java submissions."
 public class Solution {
    
    private int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        bfs(root, nodes);
        return min;
    }
    
    public void bfs(TreeNode root, List<TreeNode> parents) {
        if(root == null) return;
        
        for(TreeNode parent : parents) {
            int val = Math.abs( parent.val - root.val );
            if( val < min ) min = val;
        }
        
        parents.add(root);
        bfs(root.left, parents);
        bfs(root.right, parents);
        parents.remove(root);
    }
}
