class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int wLen = words.length;
        int[] smallFrequency = new int[ wLen ];
        for(int i = 0 ; i < wLen ; i++) {
            smallFrequency[ i ] = findSmallFrequency( words[i] );
        }
        Arrays.sort(smallFrequency);
        
        int idx = 0;
        int[] res = new int[ queries.length ];

        for(String word : queries) {
            int frequency = findSmallFrequency(word);
            int count = 0;
            for(int val : smallFrequency) {
                if( frequency < val ) break;
                count++;
            }
            res[ idx++ ] = wLen - count;
        }
        
        return res;
    }
    
    public int findSmallFrequency(String word) {
        int[] count = new int[ 256 ];
        for( char ch : word.toCharArray() ) {
            count[ ch ]++;
        }
        for(int i = 0 ; i < 256 ; i++) {
            if( count[ i ] > 0 ) return count[i];
        }
        return 0; // empty string
    }
}
