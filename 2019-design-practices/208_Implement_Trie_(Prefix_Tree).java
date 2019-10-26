class Trie {
    
    class Node {
        char ch;
        Node[] nodes;
        boolean isWord;
        
        public Node(char ch) {
            this.ch = ch;
            this.nodes = new Node[26];
        }
    }
    
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node('-');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for( char ch : word.toCharArray() ) {
            int idx = ch - 'a';
            if( cur.nodes[ idx ] == null ) {
                cur.nodes[ idx ] = new Node( ch );
            }
            cur = cur.nodes[ idx ];
        }
        
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for( char ch : word.toCharArray() ) {
            int idx = ch - 'a';
            if( cur.nodes[idx] == null ) return false;
            cur = cur.nodes[idx];
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for( char ch : prefix.toCharArray() ) {
            int idx = ch - 'a';
            if( cur.nodes[idx] == null ) return false;
            cur = cur.nodes[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
