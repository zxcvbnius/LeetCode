class Solution {
    public boolean checkRecord(String s) {
        int countA = 0;
        int countL = 0;
        for( char ch : s.toCharArray() ) {
            if( ch == 'A' ) {
                countA++;
                if( countA > 1) return false;
            }
            
            if ( ch == 'L' ) {
                countL++;
                if( countL > 2) return false;
            } else {
                countL = 0;   
            }
        }
        return true;
    }
}
