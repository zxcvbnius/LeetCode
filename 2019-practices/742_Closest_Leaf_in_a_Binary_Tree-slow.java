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
    public int findClosestLeaf(TreeNode root, int k) {
        // build a bidirection graph
        HashMap<TreeNode, Set<TreeNode>> map = buildGraph(root);

        // find target
        TreeNode target = findTarget(root, k);
        if(target.left == null && target.right == null) return k; // target is leaf
        
        // using BFS to find leaf
        TreeNode res = findLeaf(target, map);
        return res.val;
    }
    
    public TreeNode findLeaf(TreeNode target, HashMap<TreeNode, Set<TreeNode>> map) {
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
                
                for(TreeNode n: map.get(node)) {
                    if( n != null && !visited.containsKey(n) ) tmp.add(n);
                }
                size--;
            }
            stack = tmp;
        }
        return null;
    }
    
    public HashMap buildGraph(TreeNode root) {
        // use bfs to visit all nodes & leaves
        HashMap<TreeNode, Set<TreeNode>> map = new HashMap<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        
        Stack<TreeNode> stack = new Stack<>();
        stack.add( root );
        
        while( !stack.isEmpty() ) {
            Stack<TreeNode> tmp = new Stack<>();
            int size = stack.size();
            while( size > 0 ) {
                TreeNode node = stack.pop();
                visited.put(node, true);
                
                if( !map.containsKey(node) ) map.put( node, new HashSet<>() );
                
                if(node.left != null && !visited.containsKey(node.left) ) {
                    tmp.add(node.left);
                    if( !map.containsKey(node.left) ) map.put( node.left, new HashSet<>() );
                    map.get(node).add( node.left );
                    map.get(node.left).add( node );
                }
                
                if(node.right != null&& !visited.containsKey(node.right) ) {
                    tmp.add(node.right);
                    if( !map.containsKey(node.right) ) map.put( node.right, new HashSet<>() );
                    map.get(node).add( node.right );
                    map.get(node.right).add( node );
                }
                size--;
            }
            stack = tmp;
        }
        return map;
    }
    
    public TreeNode findTarget(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        stack.add( root );

        while( !stack.isEmpty() ) {
            Stack<TreeNode> tmp = new Stack<>();
            int size = stack.size();
            while( size > 0 ) {
                TreeNode node = stack.pop();
                visited.put( node, true );
                
                if( node.val == k) return node;
                if( node.left != null && !visited.containsKey(node.left) ) tmp.add(node.left);
                if( node.right != null && !visited.containsKey(node.right) ) tmp.add(node.right);

                size--;
            }
            
            stack = tmp;
        }
        return null;
    }
}
