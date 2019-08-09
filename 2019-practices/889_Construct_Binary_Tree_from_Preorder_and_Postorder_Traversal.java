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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return build(pre, post, 0, 0, pre.length);
    }
    
    public TreeNode build(int[] pre, int[] post, int preIdx, int postIdx, int len) {
        // preIdx: the start index of pre-order array
        // postIdx: the start index of post-order array
        // len: the length of subtree
        if(len <= 0) return null;
        if(len == 1) return new TreeNode( pre[preIdx] );

        TreeNode root = new TreeNode( pre[preIdx] );
        int k = postIdx;
        while( pre[preIdx + 1] != post[k] ) k++;
        int l = k - postIdx + 1;
        
        TreeNode left = build( pre, post, preIdx + 1, postIdx, l );
        TreeNode right = build( pre, post, preIdx + l + 1 , k + 1, len - l - 1);
        
        root.left = left;
        root.right = right;
        return root;
    }
}
