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
    class Node {
        TreeNode treeNode;
        int hd;
        public Node(TreeNode treeNode, int hd) {
            this.treeNode = treeNode;
            this.hd = hd;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if( root == null ) return res;
        
        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        int minHd = Integer.MAX_VALUE, maxHd = Integer.MIN_VALUE;
        
        queue.offer( new Node(root, 0) );
        
        while( !queue.isEmpty() ) {
            Node n = queue.poll();
            if( !map.containsKey( n.hd ) ) map.put( n.hd, new ArrayList<>() );

            map.get( n.hd ).add( n.treeNode.val );

            minHd = Math.min( minHd, n.hd );
            maxHd = Math.max( maxHd, n.hd );
            
            if( n.treeNode.left != null ) {
                queue.offer( new Node( n.treeNode.left, n.hd - 1) );
            }
            
            if( n.treeNode.right != null ) {
                queue.offer( new Node( n.treeNode.right, n.hd + 1) );
            }
        }
        
        for(int i = minHd ; i <= maxHd ; i++ ) {
            if( map.containsKey(i) ) {
                res.add( map.get(i) );
            }
        }
        
        return res;
    }
}
