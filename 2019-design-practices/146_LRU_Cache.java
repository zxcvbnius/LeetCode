class LRUCache {
    
    class Node {
        Node prev;
        Node next;
        int val;
        int key;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    int capacity;
    HashMap<Integer, Node> map;
    
    Node head = null;
    Node tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if( node == null ) return -1;
        if(node == head ) {
            // do nothing
        }
        else if( node == tail ) {
            popTail();
            addNode(node);
        } else {
            moveToHead(node);
        }
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if( node != null ) {
            node.val = value;
            if(node == head) {
                // do nothing
            } else if(node == tail) {
                popTail();
                addNode(node);
            } else {
                moveToHead(node);
            }
            return;
        } 
        
        if( map.size() < capacity ) {
            node = new Node( key, value );
            addNode(node);
            map.put(key, node);
            if( tail == null ) tail = node;
        } else {
            map.remove(tail.key);
            popTail();
            node = new Node( key, value );
            addNode(node);
            map.put(key, node);
        }
    }
    
    private void addNode(Node node) {
        node.prev = null;
        node.next = head;
        if( head != null ) head.prev = node;
        head = node;
    }
    
    private void popTail() {
        if( tail == null ) return;
        if( head == tail ) {
            head = null;
            tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }
    
    private void moveToHead(Node node) {
        if(node.prev != null ) node.prev.next = node.next;
        if(node.next != null ) node.next.prev = node.prev;
        addNode(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
