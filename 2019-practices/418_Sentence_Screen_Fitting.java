class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int sLength = sentence.length;
        int[] lens = new int[ sLength ];

        for(int i = 0 ; i < sLength ; i++ ) {
            lens[i] = sentence[i].length();
            if( lens[i] > cols ) return 0; // cannot fit
        }
        
        int r = 0, c = 0, idx = 0, count = 0;
        while( r < rows ) {
            int emptyLen = cols - c;
            if( lens[idx] <= emptyLen ) {
                c += (lens[idx] + 1); // need '-'
                
                idx++;
                if( idx >= sLength ) {
                    count++;
                    idx = 0;
                }
                
            } else {
                r++;
                c=0;
                continue;
            }
            
            if( c >= cols ) {
                r++;
                c = 0;
            }
        }
        return count;
    }
}
