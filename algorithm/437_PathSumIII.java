/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * Example:
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * 
 * 
 * Result. "Your runtime beats 75.79% of java submissions."
 */
public class Solution {
    
    private int count = 0;
    
    public int pathSum(TreeNode root, int target) {
        if(root != null) findValue(root, 0, target, false);
        return count;
    }
    
    public void findValue(TreeNode node, int curSum, int target, boolean isHead) {
        curSum += node.val;
        if(curSum == target) count++;
        
        if(node.left != null) {
            findValue(node.left, curSum, target, isHead);    
            if(!isHead) findValue(node.left, 0, target, true);
        }
        
        if(node.right != null) {
            findValue(node.right, curSum, target, isHead);
            if(!isHead) findValue(node.right, 0, target, true);
        }
    }
    
}
