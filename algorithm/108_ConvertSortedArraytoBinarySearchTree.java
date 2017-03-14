/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * Result. "Your runtime beats 15.00% of java submissions."
 */
 public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
    public TreeNode sortedArrayToBST(int[] nums, int lo, int hi){
        if(lo > hi)
            return null;
        int mid = (hi-lo)/2+lo;
        TreeNode root = new TreeNode(nums[mid]);
        root.left =  sortedArrayToBST(nums, lo, mid-1);
        root.right =  sortedArrayToBST(nums, mid+1, hi);
        return root;
    }
}
