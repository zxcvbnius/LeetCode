class Solution {
    public int shortestWay(String source, String target) {
        int count = 0;
        char[] sChar = source.toCharArray();
        char[] tChar = target.toCharArray();
        
        int sLen = sChar.length, tLen = tChar.length, tPos = 0;
        
        while( tPos < tLen ) {
            int sPos = 0;
            int subLen = 0;
            
            while( sPos < sLen && tPos < tLen ) {
                if( sChar[sPos] ==  tChar[tPos]) {
                    tPos++;
                    subLen++;
                }
                sPos++;
            }
            
            if(subLen == 0) return -1;
            
            count++;
        }
        
        
        return count;
    }
}
