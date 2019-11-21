/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Node cur = root;
        
        while( cur != null ) {
            Node tmp = cur;
            while( tmp != null ) {
                if( tmp.left != null ) tmp.left.next = tmp.right;
                if( tmp.right != null && tmp.next != null ) {
                    tmp.right.next = tmp.next.left;
                }
                tmp = tmp.next;
            }
            cur = cur.left;
        }
        
        return root;
    }
}
