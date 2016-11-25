/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * 
 * Result. "Your runtime beats 21.17% of java submissions."
 */
 public class Solution {
    
    private ArrayList<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return res;
        
        ArrayList<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        
        while(true) {
            
            ArrayList<Integer> vals = new ArrayList<>();
            for(TreeNode t : temp) {
                vals.add(t.val);
            }
            res.add(vals);
            
            temp = getChildren(temp);
            if(temp.size() == 0) break;
            
        }
        
        Collections.reverse(res);
        return res;
        
    }
    public ArrayList<TreeNode> getChildren(List<TreeNode> parents) {
        ArrayList<TreeNode> list = new ArrayList<>();
        for(TreeNode p : parents) {
            if(p.left != null) list.add(p.left);
            if(p.right != null) list.add(p.right);
        }
        return list;
    }
}
