/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        Node node = head;
        while( node != null ) {
            if( node.child == null ) { // no child
                node = node.next;
                continue;
            }
            
            // has child
            Node next = node.next;
            Node tmp = node.child;
            while( tmp.next != null ) tmp = tmp.next;
            
            tmp.next = next;
            if(next != null) next.prev = tmp;
            
            node.next = node.child;
            node.child.prev = node;
            
            node.child = null;
        }
        return head;
    }
}
