class Solution {
    public String licenseKeyFormatting(String S, int K) {
        char[] sChar = S.toCharArray();
        int len = sChar.length;
        
        StringBuilder sb = new StringBuilder();
        
        int curCount = 0;
        for(int i = len - 1 ; i >= 0 ; i-- ) {
            char ch = sChar[i];

            if(curCount == K) {
                sb.append('-');
                curCount = 0;
            }
            
            if( ch != '-' ) {
                curCount++;
                sb.append( Character.toUpperCase(ch) );
            }
        }
        
        
        int sbLen = sb.length(), i = sbLen - 1;
        int count = 0;
        while(i >= 0) {
            if( sb.charAt(i) == '-' ) count++;
            else break;
            i--;
        }
        
        if(count > 0) sb.delete( sbLen - count, sbLen );
        
        sb = sb.reverse();
        return sb.toString();
    }
}
