class Solution {
    public char findTheDifference(String s, String t) {
        int[] count = new int[256];
        for( char ch : s.toCharArray() ) {
            count[ ch ]++;
        }
        
        for( char ch : t.toCharArray() ) {
            if( count[ch] == 0 ) return ch;
            count[ch]--;
        }
        return '-';
    }
}
