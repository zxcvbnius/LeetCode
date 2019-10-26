/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // if null, set #
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        // bad design
        idx = -1;
        return buildTree(tokens);
    }
    
    int idx = -1;
    public TreeNode buildTree(String[] tokens) {
        idx++;
        if( idx >= tokens.length ) return null;
        if( tokens[ idx ].equals("#") ) return null;
        
        TreeNode node = new TreeNode( Integer.valueOf(tokens[idx]) );
        
        node.left = buildTree(tokens);
        node.right = buildTree(tokens);
        
        return node;
    }
    
    private void preorder(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append('#').append(',');
            return;
        }
        
        sb.append( node.val ).append(',');
        preorder(node.left, sb);
        preorder(node.right, sb);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
