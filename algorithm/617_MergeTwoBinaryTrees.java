/**
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * 
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 * 
 * Example 1:
 * Input: 
 * 	Tree 1                     Tree 2                  
 *           1                         2                             
 *          / \                       / \                            
 *         3   2                     1   3                        
 *        /                           \   \                      
 *       5                             4   7                  
 * Output: 
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \ 
 * 	 5   4   7
 * Note: The merging process must start from the root nodes of both trees.
 *    
 */
// Result. "Your runtime beats 22.99% of java submissions." (Most ppl in the range)
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode res = getMergeNode(t1, t2);
        return res;        
    }
    
    private TreeNode getMergeNode(TreeNode cur1, TreeNode cur2) {
        TreeNode res = new TreeNode(0);
        if(cur1 == null && cur2 == null) return null;
        else if(cur1 == null) res = new TreeNode(cur2.val);
        else if(cur2 == null) res = new TreeNode(cur1.val);
        else res = new TreeNode(cur1.val + cur2.val); 
        
        if(cur1 != null && cur2 != null) {
            res.left  = getMergeNode(cur1.left, cur2.left);
            res.right = getMergeNode(cur1.right, cur2.right);
        } else if(cur1 != null) {
            res.left  = getMergeNode(cur1.left, null);
            res.right = getMergeNode(cur1.right, null);
        } else if(cur2 != null) {
            res.left  = getMergeNode(cur2.left, null);
            res.right = getMergeNode(cur2.right, null);
        }
        
        return res;
    }
}
