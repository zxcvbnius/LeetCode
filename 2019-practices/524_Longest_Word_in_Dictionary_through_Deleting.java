class Solution {
    public String findLongestWord(String s, List<String> d) {
        
        int len = 0;
        String res = "";
        
        for(String word : d) {
            if( word.length() > s.length() )  continue;
            if( !isValid(s, word) ) continue; // only allow valid words keep go on
            
            if( word.length() > len || (word.length() == len && word.compareTo(res) < 0 ) ) {
                len = word.length();
                res = word;
            }
        }
        return res;
    }
    
    public boolean isValid(String source, String target) {
        int sLen = source.length(), tLen = target.length(), idx1 = 0, idx2 = 0;

        while( idx1 < sLen && idx2 < tLen ) {
            if( source.charAt(idx1) != target.charAt(idx2) ) {
                idx1++;
                continue;
            }
            
            idx1++;
            idx2++;
        }
        
        return idx2 == tLen;
    }
}
