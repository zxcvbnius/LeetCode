class Solution {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if( root == null ) return new TreeNode[]{ null, null }; // left, right

        if( root.val > V ) {
            TreeNode[] res = splitBST( root.left, V);
            root.left = res[1];
            return new TreeNode[]{ res[0], root };
        } else {
            TreeNode[] res = splitBST( root.right, V );
            root.right = res[0];
            return new TreeNode[]{ root, res[1] };
        }
    }
}
