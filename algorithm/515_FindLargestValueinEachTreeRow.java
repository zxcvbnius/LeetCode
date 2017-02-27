/**
 * You need to find the largest value in each row of a binary tree.
 * 
 * Example:
 * Input: 
 * 
 *           1
 *          / \
 *         3   2
 *        / \   \  
 *       5   3   9 
 * 
 * Output: [1, 3, 9]
 * Result. "Your runtime beats  *  of java submissions"
 */
 public class Solution {
    
    private HashMap<Integer, Integer> map = new HashMap<>();
    private List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        findMaxValue(root, 0);
        int index = 0;
        while(true) {
            Integer val = map.get(index);
            if(val == null) break;
            result.add(val);
            index++;
        }
        return result;
    }
    
    public void findMaxValue(TreeNode currentNode, int depth) {
        if(currentNode == null) return;
        Integer val = map.get(depth);
        if( val == null || val < currentNode.val ) map.put(depth, currentNode.val);
        if(currentNode.right != null) findMaxValue(currentNode.right, depth + 1);
        if(currentNode.left != null) findMaxValue(currentNode.left, depth + 1);
    }
}
