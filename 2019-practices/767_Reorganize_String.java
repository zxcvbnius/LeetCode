class Solution {
    public String reorganizeString(String S) {
        int[] chars = new int[26];
        for( char ch : S.toCharArray() ) chars[ ch - 'a' ]++;
        
        // find max
        int maxCount = 0, maxIdx = -1;
        for(int i = 0 ; i < 26 ; i++) {
            if( maxCount < chars[i] ) {
                maxCount = chars[i];
                maxIdx = i;
            }
        }
        
        if( maxCount > (S.length() + 1) / 2 ) return "";
        
        int[] res = new int[ S.length() ];
        int idx = 0;
        while( chars[maxIdx] > 0 ) {
            res[idx] = maxIdx;
            idx += 2;

            chars[maxIdx]--;
        }
        
        for(int i = 0 ; i < 26 ; i++) {
            while( chars[i] > 0 ) {
                if( idx >= S.length() ) idx = 1;
                res[idx] = i;
                idx += 2;
                
                chars[i]--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < res.length ; i++) {
            sb.append( (char)( res[i] + 'a') );
        }
        
        return sb.toString();
        
    }
}
