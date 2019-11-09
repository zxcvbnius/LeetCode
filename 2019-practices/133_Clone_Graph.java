/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        return clone(node, map);
    }
    
    public Node clone(Node src, HashMap<Node, Node> map) {
        if( map.containsKey(src) ) return map.get(src);
        
        Node n = new Node( src.val, new ArrayList<Node>());
        map.put( src, n);
        
        
        for( Node neighbor : src.neighbors ) {
            if( map.containsKey(neighbor) ) {
                n.neighbors.add( map.get( neighbor) );
            } else {
                n.neighbors.add( clone( neighbor, map) );
            }
        }
        return n;
    }
}
