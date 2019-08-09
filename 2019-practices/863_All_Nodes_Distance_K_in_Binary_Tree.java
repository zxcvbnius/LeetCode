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
    public HashMap< TreeNode, List<TreeNode> > map = new HashMap<>();
    public Stack< TreeNode > stack = new Stack<>();
    public HashMap< TreeNode, Boolean > visited = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        buildGraph( root, root.left);
        buildGraph( root, root.right);

        List<Integer> res = new ArrayList<>();

        for(int i = 0 ; i <= K ; i++) {
            Stack<TreeNode> stackTmp = new Stack<>();
            if( i == 0 ) stackTmp.add( target );
            visited.put( target, true );
            
            while( !stack.isEmpty() ) {
                TreeNode node = stack.pop();
                for(TreeNode n : map.get( node )) {
                    if (n != null && !visited.containsKey(n)) {
                        stackTmp.add( n );
                        visited.put(n , true);
                    }
                }
            }
            stack = stackTmp;
        }
        
        while( !stack.isEmpty() ) {
            TreeNode node = stack.pop();
            if(node != null) res.add( node.val );
        }
                
        return res;
    }
    
    public void buildGraph(TreeNode parent, TreeNode child) {
        List<TreeNode> list = map.get( parent );
        if( list == null ) {
            list = new ArrayList<>();
            list.add( child );
            map.put( parent, list);
        } else {
            list.add( child );
        }
        
        List<TreeNode> list2 = map.get( child );
        if( list2 == null ) {
            list2 = new ArrayList<>();
            list2.add( parent );
            map.put( child, list2);
        } else {
            list2.add( parent );
        }
        
        if( child != null && child.left != null ) buildGraph(child, child.left);
        if( child != null && child.right != null ) buildGraph(child, child.right);
    }
}
