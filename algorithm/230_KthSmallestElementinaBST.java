/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Result. "Your runtime beats 52.92% of java submissions."
 */
 public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        inorder(root, k, list);
        return list.get( k - 1).val;
    }
    
    private void inorder(TreeNode curNode, int k, ArrayList<TreeNode> list) {
        if(list.size() >= k || curNode == null) return;
        
        inorder(curNode.left, k, list);
        list.add(curNode);
        if(list.size() == k) return;
        inorder(curNode.right, k, list);
    }
}
