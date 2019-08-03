class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        boolean[] replace = new boolean[ sources.length ];
        
        char[] sChar = S.toCharArray();
        HashMap<Integer, Integer> replaces = new HashMap<>(); // index of schar, index of indexes array
        
        for(int i = 0 ; i < indexes.length ; i++) {
            char[] sourceChars = sources[i].toCharArray();
            int sPos = indexes[i];
            int offset = 0;
            
            boolean isReplaced = true;
            while( sPos < sChar.length && offset < sourceChars.length ) {
                if( sChar[sPos++] != sourceChars[offset++] ) {
                    isReplaced = false;
                    continue;
                }
            }
            if(isReplaced) {
                replaces.put( indexes[i], i );
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < sChar.length ; i++) {
            if( replaces.containsKey( i ) ) {
                int index = replaces.get(i);
                char[] tChar = targets[ index ].toCharArray();
                int offset = 0;
                while(offset < tChar.length) {
                    sb.append( tChar[offset++] );
                }
                i += sources[ index ].length() - 1;
            } else {
                sb.append( sChar[i] );
            }
        }
        
        return sb.toString();
    }
}
