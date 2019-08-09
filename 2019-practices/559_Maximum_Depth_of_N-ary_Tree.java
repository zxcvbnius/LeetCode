/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        return dfs(root, 0);
    }
    
    public int dfs(Node node, int depth) {
        if( node == null ) return depth;
        
        List<Node> children = node.children;
        int max = depth;
        for(int i = 0 ; i < children.size() ; i++) {
            int subDepth =  dfs( children.get(i), depth );
            if( max < subDepth) max = subDepth;
        }
        
        return max + 1;
    }
}
