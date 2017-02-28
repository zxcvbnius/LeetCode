/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 * 
 * Examples 1
 * Input:
 * 
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 * 
 *   5
 *  /  \
 * 2   -5
 * 
 * Result. "Your runtime beats 59.50% of java submissions."
 */
 public class Solution {
    
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int maxCount = -1;
    public int[] findFrequentTreeSum(TreeNode root) {
        
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return new int[0];
        
        postOrderReturnSum(root, 0);
        
        Set<Integer> keys = map.keySet();
		for(Integer key : keys) {
			int val = map.get(key);
			if(val == maxCount) result.add(key);
		}
		int len = result.size();
		int[] aws = new int[len];
		for(int i = 0 ; i < len ; i++) {
		    aws[i] = result.get(i);
		}
		return aws;
    }
    
    public int postOrderReturnSum(TreeNode currentNode, int currentSum) {
        if(currentNode.left == null && currentNode.right == null) {
            map.put(currentNode.val, map.getOrDefault(currentNode.val, 0) + 1);
            if( map.get(currentNode.val) > maxCount ) maxCount = map.get(currentNode.val);
            return currentSum + currentNode.val;
        }
        int left = 0;
        if(currentNode.left != null) {
            left = postOrderReturnSum(currentNode.left, currentSum);
        }
        int right = 0;
        if(currentNode.right != null) {
            right = postOrderReturnSum(currentNode.right, currentSum);
        }
        int sum = left + right + currentNode.val;
        
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        if( map.get(sum) > maxCount ) maxCount = map.get(sum);
        
        return sum;
    }
}
