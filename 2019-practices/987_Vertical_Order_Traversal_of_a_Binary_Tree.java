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

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if( root == null ) return res;
        
        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        int minHd = Integer.MAX_VALUE, maxHd = Integer.MIN_VALUE;
        
        queue.offer( new Node(root, 0) );
        
        while( !queue.isEmpty() ) {
            int size = queue.size();
            Map<Integer,List<Integer>> tmp = new HashMap();
            
            while( size-- > 0 ) {
                Node n = queue.poll();
                if( !tmp.containsKey( n.hd ) ) tmp.put( n.hd, new ArrayList<>() );

                tmp.get( n.hd ).add( n.treeNode.val );

                minHd = Math.min( minHd, n.hd );
                maxHd = Math.max( maxHd, n.hd );

                if( n.treeNode.left != null ) {
                    queue.offer( new Node( n.treeNode.left, n.hd - 1) );
                }

                if( n.treeNode.right != null ) {
                    queue.offer( new Node( n.treeNode.right, n.hd + 1) );
                }
            }
            
            for(int key : tmp.keySet()){
                if(!map.containsKey(key)) map.put(key, new ArrayList<Integer>());
                
                Collections.sort(tmp.get(key));
                map.get(key).addAll(tmp.get(key));
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
