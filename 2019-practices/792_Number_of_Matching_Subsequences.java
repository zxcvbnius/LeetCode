class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        HashMap<Character, List<Node>>  map = new HashMap<>();
        for(char i = 'a' ; i <= 'z' ; i++) map.put( i, new ArrayList<>() );

        for(String w : words) {
            map.get( w.charAt(0) ).add( new Node(w, 0) );
        }

        int ans = 0;
        for( char ch : S.toCharArray() ) {
            List<Node> nodes = map.get( ch );
            map.put( ch, new ArrayList<>() );

            for(Node n : nodes) {
                n.index++;
                if( n.word.length() == n.index ) ans++;
                else {
                   map.get( n.word.charAt( n.index ) ).add( n );
                }
            }
        }

        return ans;
    }

    class Node {
        String word;
        int index;
        public Node(String w, int i) {
            word = w;
            index = i;
        }
    }
}

// slow
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        Set<String> wordSet = new TreeSet<>();
        HashMap<String, Integer> count = new HashMap<>();
        for(String w : words) {
            count.put( w, count.getOrDefault(w, 0) + 1 );
            wordSet.add( w );
        }
        
        List<String> wordList = new ArrayList<>();
        for( String w : wordSet ) wordList.add( w );
        
        
        int wLen = wordList.size();
        int[] lens = new int[ wLen ];
        int[] indics = new int[ wLen ];
        
        for(int i = 0 ; i < wLen ; i++) lens[ i ] = wordList.get(i).length();
        
        for( char ch : S.toCharArray() ) {
            for(int i = 0 ; i < wLen ; i++) {
                if( lens[i] <= indics[i] ) continue;
                if( wordList.get(i).charAt(indics[i]) == ch ) indics[i]++;
            }
        }
        
        int ans = 0;
        for(int i = 0 ; i < wLen ; i++) {
            if(indics[ i ] == lens[i]) {
                ans += count.get( wordList.get(i) );
            }   
        }
        
        return ans;
    }
}
