/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            head = new Node(1, null);
            head.next = head;
            return head;
        }
        Node cur = head;
        
        Node min = head;
        Node max = head;
        cur = cur.next;
        
        while(cur != head) {
            if(cur.val < min.val) min = cur;
            if(cur.val >= max.val) max = cur;
            cur = cur.next;
        }
        
        if(insertVal < min.val || insertVal > max.val) {
            Node insertNode = new Node(insertVal, min);
            max.next = insertNode;
            return head;
        }
        
        while(true) {
            if( cur.next.val >= insertVal && cur.val <= insertVal ) {
                Node next = cur.next;
                cur.next = new Node(insertVal, next);
                break;
            }
            cur = cur.next;
        }
        
        return head;
    }
}
