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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        
        int len = nums.length;
        int lastIndex = len - 1;
        
        int middleIndex = (0 + lastIndex) / 2 + ( 0 + lastIndex) % 2;
        TreeNode root = new TreeNode( nums[middleIndex] );
        
        TreeNode leftNode = buildTree(nums, 0, middleIndex-1);
        TreeNode rightNode = buildTree(nums, middleIndex+1, len - 1);
        
        root.left = leftNode;
        root.right = rightNode;
        
        return root;
    }
    
    public TreeNode buildTree(int[] nums, int start, int end) {
        if(start == end) {
            TreeNode node = new TreeNode( nums[start] );
            node.left = null;
            node.right = null;
            return node;
        }
        
        if (start > end) {
            return null;
        }
        
        int middleIndex = (start + end ) / 2 + (start + end ) % 2;
        
        TreeNode node = new TreeNode(nums[middleIndex]);
            
        TreeNode leftNode = buildTree(nums, start, middleIndex - 1);
        TreeNode rightNode = buildTree(nums, middleIndex + 1, end);
        
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
}
