/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * For example:
 * Given BST [1,null,2,2],
 *    1
 *     \
 *      2
 *     /
 *    2
 * return [2].
 *  
 * Result. "Your runtime beats 47.33% of java submissions." (Most ppl in the range)
 */
 
public class Solution {
    public int[] findMode(TreeNode root) {
        
        if(root == null) return new int[0];
        
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        
        ArrayList<Integer> list = new ArrayList<>();
        for(Integer v : map.keySet()) {
            int val = map.get(v);
            if( val == maxCount) list.add(v);
        }
        
        int[] aws = new int[list.size()];
        int count = 0;
        for(Integer v : list) {
            aws[count++] = v;
        }
        return aws;
    }
    int maxCount = 0;
    public void dfs(TreeNode curNode, Map<Integer, Integer> map) {
        
        Integer val = map.get(curNode.val); 
        int count = (val == null) ? 1 : val + 1 ;
        map.put(curNode.val, count);
        if(maxCount < count) maxCount = count;
        
        if(curNode.right == null && curNode.left == null) { // leaf
            return;
        }
        if(curNode.right != null) dfs(curNode.right, map);
        if(curNode.left != null) dfs(curNode.left, map);
    }
}
