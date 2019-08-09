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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), root, sum);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> list, TreeNode node, int remaining) {
        if(node == null) return;
        if(node.val == remaining && node.left == null && node.right == null) { // leaf
            list.add(node.val);
            res.add( new ArrayList(list) );
            list.remove( list.size() - 1);
            return;
        }
        
        list.add(node.val);
        remaining = remaining - node.val;
        
        dfs( res, list, node.left,  remaining);
        dfs( res, list, node.right,  remaining);
        
        list.remove( list.size() - 1);
        
        return;
    }
}
