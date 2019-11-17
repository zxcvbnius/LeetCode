class AutocompleteSystem {

    HashMap<String, Integer> map;
    StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        map = new HashMap<>();
        sb = new StringBuilder();

        for(int i = 0 ; i < times.length ; i++ ) {
            String s = sentences[i];
            map.put( s, map.getOrDefault(s, 0) + times[i] );
        }
    }

    public List<String> input(char c) {
        if( c == '#' ) {
            String s = sb.toString();
            map.put( s, map.getOrDefault(s, 0) + 1 );
            sb = new StringBuilder();
            return new ArrayList<>();
        }

        sb.append(c);
        String target = sb.toString();

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));

        for( String s : map.keySet() ) {
            if( s.startsWith( target ) ) {
                queue.offer( new Node(s, map.get(s)) );
            }
        }

        List<String> res = new ArrayList<>();
        while( queue.size() > 0 && res.size() < 3 ) {
            Node node = queue.poll();
            res.add( node.s );
        }
        return res;
    }

    class Node {
        String s;
        int c;
        public Node(String s, int c) {
            this.s = s;
            this.c = c;
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */

