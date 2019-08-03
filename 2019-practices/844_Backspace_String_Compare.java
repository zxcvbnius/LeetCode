class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] sChar = S.toCharArray();
        char[] tChar = T.toCharArray();
        
        int sPos = 0, tPos = 0, sLen = sChar.length, tLen = tChar.length;
        
        for(int i = 0 ; i < sLen ; i++) {
            char ch = sChar[i];
            if(ch == '#') {
                sPos = Math.max( sPos - 1, 0);
                continue;
            }
            sChar[ sPos++ ] = sChar[i];
        }
        
        for(int i = 0 ; i < tLen ; i++) {
            char ch = tChar[i];
            if(ch == '#') {
                tPos = Math.max( tPos - 1, 0);
                continue;
            }
            tChar[ tPos++ ] = tChar[i];
        }
        
        if(sPos != tPos) return false;       
        int index = sPos-1;

        while(index >= 0) {
            if(sChar[index] != tChar[index]) return false;
            index--;
        }
        
        return true;
    }
}
