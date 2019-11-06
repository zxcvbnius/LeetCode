class Solution {
    public String minWindow(String S, String T) {
       // right: the end of T string (using for substring)
       // left: find the start of T string (using for substring)
       // tIdx: used for recording the position of T length
       // minLen: find the minimum length of substring
       int right = 0, minLen = Integer.MAX_VALUE;
       int sLen = S.length(), tLen = T.length();

       String res = null;

       while( right < sLen ) {
           int tIdx = 0;
           while( right < sLen ) {
               if( T.charAt( tIdx ) == S.charAt(right) ) {
                   tIdx++;
               }
               if( tIdx == tLen ) break;
               right++;
           }

           if( right == sLen ) break; // no match

           int left = right;
           tIdx = tLen - 1;
           while( left >= 0 && tIdx >= 0 ) {
               if( T.charAt(tIdx) == S.charAt(left) ) {
                   tIdx--;
               }
               if( tIdx < 0) break;
               left--;
           }

           int len = right - left + 1;
           minLen = Math.min( minLen, len );

           if( res == null || len < res.length() ) {
               res = S.substring(left, right + 1);
           }

           right = left + 1;
       }

       return res == null ? "" : res;
    }
}
