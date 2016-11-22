/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its level order traversal as:
 * 
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * Result. "Your runtime beats 35.37% of java submissions"
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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null) return res;
        
        // Initialize children
        ArrayList<TreeNode> rootList = new ArrayList<>();
        rootList.add(root);
        List<TreeNode> children = getChildren(rootList);
        
        // loop
        while(children.size() > 0) {
            children = getChildren(children);
        }
        return res;
    }
    
    public List<TreeNode> getChildren(List<TreeNode> parents) {
        ArrayList<Integer> vals = new ArrayList<>();
        List<TreeNode> children = new ArrayList<>();
        for(TreeNode node: parents) {
            if(node.left != null ) children.add(node.left);
            if(node.right != null) children.add(node.right);
            vals.add(node.val);
        }
        res.add(vals);
        return children;
    }
}
