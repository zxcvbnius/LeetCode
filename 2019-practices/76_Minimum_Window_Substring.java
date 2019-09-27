class Solution {
    public String minWindow(String s, String t) {
        int[] tCount = new int[ 256 ];
        int[] inRange = new int[ 256 ];
        for( char ch : t.toCharArray() ) {
            tCount[ ch ]++;
        }
        
        int start = -1, mEnd = -1, mStart = -1;
        char startChar = '-';

        char[] chars = s.toCharArray();
        for(int i = 0 ; i < chars.length ; i++) {
            char ch = chars[i];
            if( tCount[ ch ] > 0 ) {
                inRange[ ch ]++;
                
                if( start < 0 ) {
                    start = i;
                    startChar = ch;
                }
                
                if( startChar == ch && tCount[ch] < inRange[ ch ] ) {
                    for(int j = start ; j < chars.length ; j++) {
                        if( tCount[ chars[j] ] < inRange[ chars[j] ] ) inRange[ chars[j] ]--;
                        else if( tCount[ chars[j] ] > 0 ) {
                            start = j;
                            startChar = chars[j];
                            break;
                        }
                    }
                }
                
                // check if string is ready or not
                boolean hasAll = true;
                for( char ch_ : t.toCharArray() ) {
                    if( tCount[ch_] > inRange[ ch_ ] ) {
                        hasAll = false;
                        break;
                    }
                }
                
                if(!hasAll) continue;
                
                // calculate distance
                int len = i - start;
                if( mEnd < 0 || mEnd - mStart > len ) {
                    mEnd = i;
                    mStart = start;
                }
            }
        }
        return (mEnd < 0) ? "" : s.substring( mStart, mEnd + 1);
    }
}
