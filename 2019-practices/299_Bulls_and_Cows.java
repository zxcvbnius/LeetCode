class Solution {
    public String getHint(String secret, String guess) {
        char[] sChars = secret.toCharArray();
        char[] gChars = guess.toCharArray();
        
        int[] sFreq = new int[256];
        
        int len = sChars.length;
        int A = 0, B = 0;
        for(int i = 0 ; i < len ; i++) {
            if( sChars[i] == gChars[i] ) A++;
            else {
                sFreq[ sChars[i] ]++;
            } 
        }
        
        for(int i = 0 ; i < len ; i++) {
            if( sChars[i] == gChars[i] ) continue;
            if( sFreq[ gChars[i] ] > 0 ) {
                B++;
                sFreq[ gChars[i] ]--;
            }
             
        }
        
        return "" + A + "A" + B + "B";
    }
}
