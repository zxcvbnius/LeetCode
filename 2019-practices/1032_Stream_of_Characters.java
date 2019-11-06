class StreamChecker {

    class Node {
        char ch;
        boolean isWord;
        Node[] children;

        public Node(char ch) {
            this.ch = ch;
            this.children = new Node[26]; // a-z
        }
    }

    Node root = new Node('-');
    List<Node> list = new ArrayList<>();

    public StreamChecker(String[] words) {
        for(String word : words) {
            Node cur = root;
            for( char ch : word.toCharArray() ) {
                int idx = ch - 'a';
                if( cur.children[idx] == null ) {
                    cur.children[idx] = new Node(ch);
                }
                cur = cur.children[idx];
            }
            cur.isWord = true;
        }
    }
    
    public boolean query(char letter) {
        int idx = letter - 'a';
        boolean result = false;

        List<Node> tmp = new ArrayList<>();

        for(int i = 0 ; i < list.size() ; i++) {
           Node node = list.get(i);

           if( node.children[ idx ] != null && node.children[ idx ].isWord ) result = true;
           if( node.children[ idx ] != null ) tmp.add( node.children[idx] );
        }

        if( root.children[ idx ] != null ) {
            if( root.children[ idx  ].isWord ) result = true;
            root.add( root.children[idx] );
        }
        list = tmp;

        return result;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
