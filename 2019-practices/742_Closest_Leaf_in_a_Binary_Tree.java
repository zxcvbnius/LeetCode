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
    public TreeNode target = null;
    public HashMap <TreeNode, TreeNode> parents = new HashMap<>(); // child , parent

    public int findClosestLeaf(TreeNode root, int k) {
        // build a bidirection graph
        buildGraph(root, k);
        if(target.left == null && target.right == null) return k; // target is leaf
        
        // using BFS to find leaf
        TreeNode res = findLeaf(target, parents);
        return res.val;
    }
    
    public TreeNode findLeaf(TreeNode target, HashMap<TreeNode, TreeNode> parents) {
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add( target );
        
        while( !stack.isEmpty() ) {
            Stack<TreeNode> tmp = new Stack<>();
            int size = stack.size();
            while( size > 0 ) {
                TreeNode node = stack.pop();
                visited.put(node, true);
                
                if( node.left == null && node.right == null) return node;
                
                if( node.left != null && !visited.containsKey(node.left) ) tmp.add(node.left);
                if( node.right != null && !visited.containsKey(node.right) ) tmp.add(node.right);
                if(parents.containsKey( node ) ) {
                    TreeNode parent = parents.get( node );
                    if( !visited.containsKey(parent) ) tmp.add( parent );
                }
                size--;
            }
            stack = tmp;
        }
        return null;
    }
    
    public void buildGraph(TreeNode root, int k) {
        // use bfs to visit all nodes & leaves
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        
        Stack<TreeNode> stack = new Stack<>();
        stack.add( root );
        
        while( !stack.isEmpty() ) {
            Stack<TreeNode> tmp = new Stack<>();
            int size = stack.size();
            while( size > 0 ) {
                TreeNode node = stack.pop();
                visited.put(node, true);
                
                if( node.val == k) target = node;
                
                if(node.left != null) {
                    if(!visited.containsKey(node.left)) tmp.add( node.left );
                    parents.put( node.left, node);  
                } 
                
                if(node.right != null) {
                    if(!visited.containsKey(node.right)) tmp.add( node.right );
                    parents.put( node.right, node);  
                }
                size--;
            }
            stack = tmp;
        }
    }
}
