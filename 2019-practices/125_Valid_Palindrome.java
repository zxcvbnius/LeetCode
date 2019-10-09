class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();

        int lo = 0 , hi = len - 1;
        while( lo < hi ) {
            while( lo < len && !isAlpha( s.charAt(lo) ) ) lo++;
            if( lo >= len ) break;
            while(hi >= 0 && !isAlpha( s.charAt(hi) ) ) hi--;
            if( hi < 0 ) break;
            
            if( toLowerCase( s.charAt(lo) ) != toLowerCase( s.charAt(hi) ) ) return false;
            lo++;
            hi--;   
        }
        
        return true;
    }
    
    public boolean isAlpha(char ch) {
        return ( ch >= 'a' && ch <= 'z') || ( ch >= 'A' && ch <= 'Z') || ( ch >= '0' && ch <= '9');
    }
    
    public Character toLowerCase(char ch) {
        if( ch >= 'a' && ch <= 'z') return ch;
        return (char)(ch - 'A' + 'a');
    }
}
