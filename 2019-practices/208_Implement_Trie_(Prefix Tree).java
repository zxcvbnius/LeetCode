class Trie {
    
    class TrieNode {
        public char ch;
        public boolean is_word = false;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode(char ch) {
            this.ch = ch;
        }
    }
    
    public TrieNode findNode(char[] wChars, TrieNode root) {
        int len = wChars.length;

        for(int i = 1 ; i < len ; i++) { // start from children
            char ch = wChars[i];
            if( root.children[ ch - 'a' ] == null ) return null;
            root = root.children[ ch - 'a'];
        }
        
        return root;
    }
    
    HashMap<Character, TrieNode> map = new HashMap<>();

    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null) return;

        char[] words = word.toCharArray();
        int size = words.length;

        if( !map.containsKey( words[0] ) ) map.put( words[0], new TrieNode(words[0]) );
        TrieNode node = map.get( words[0] );

        for(int i = 1 ; i < size ; i++) {
            char ch = words[i];
        
            if( node.children[ ch - 'a' ] == null) node.children[ ch - 'a' ] = new TrieNode( ch );
            node = node.children[ ch - 'a' ];
        }
        node.is_word = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null) return false;
        char[] wChars = word.toCharArray();

        if( !map.containsKey( wChars[0]) ) return false;
        
        TrieNode root = map.get( wChars[0] );
        TrieNode node = findNode(wChars, root);
        return node != null && node.is_word;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null) return false;
        char[] wChars = prefix.toCharArray();
        
        if( !map.containsKey( wChars[0]) ) return false;

        TrieNode root = map.get( wChars[0] );
        TrieNode node = findNode(wChars, root);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
