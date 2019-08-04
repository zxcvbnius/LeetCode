/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Node newHead = new Node(head.val, head.next, null);
        
        HashMap<Node, Integer> posMap = new HashMap<>();
        ArrayList<Node> list = new ArrayList<>(); // record new nodes
        
        int curPos = 0; // record sources nodes pos

        Node cur = head;
        Node cur1 = newHead;
        
        posMap.put(cur, curPos); // handle head case
        curPos++;
        cur = cur.next;
        list.add(newHead);
        
        while(cur != null) { // generate new node lists without random node
            posMap.put(cur, curPos);

            Node node = new Node(cur.val, cur.next, null);
            list.add(node);
            
            cur1.next = node;
            cur1 = cur1.next;
            
            cur = cur.next;
            curPos++;
        }
        
        curPos = 0; // reset point to head & setup random
        cur = head;
        cur1 = newHead;
        
        while(cur != null) {
            if( cur.random != null ) {
                int pos = posMap.get( cur.random );
                cur1.random = list.get( pos );
            }
            cur1 = cur1.next;
            cur = cur.next;
        }
        return newHead;
    }
}
