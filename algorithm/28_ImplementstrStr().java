/**
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Result. "Your runtime beats 47.59% of java submissions :("
 */
 public class Solution {
    public int strStr(String haystack, String needle) {
        
        if(haystack == null || needle == null) return -1;
        else if(needle.length() == 0) return 0;
        else if(haystack.length() == 0) return (needle.length() == 0) ? 0 : -1;
        
        
        char[] sChars = haystack.toCharArray(); // haystack is text
        char[] tChars = needle.toCharArray(); // needle is pattern
        
        int[]  next   = new int[ tChars.length ];
        
        getNextTable(tChars, next);
        
        int res = getKMPIndex(sChars, tChars, next);
        return res;
    }
    
    public void getNextTable(char[] tChars, int[] next) {
        next[0] = 0;
        int length = 0, curIndex = 1;
        while(curIndex < tChars.length) {
            if(tChars[curIndex] == tChars[length]) { // match is found
                length++;
                next[curIndex] = length;
                curIndex++;
            } else {
                if(length != 0) { // mismatch case
                    length = next[length - 1];
                } else {
                    next[curIndex] = 0;
                    curIndex++;
                }
            }
        }
    }
    
    public int getKMPIndex(char[] s, char[] t, int[] next) {
        
        int sIndex = 0, tIndex = 0;
        while(sIndex < s.length) {
            if(s[sIndex] == t[tIndex] ) { // so far matched 
                tIndex++;
                sIndex++;
            }
            
            if( tIndex == t.length ) {
                // sIndex = next[sIndex - 1]
                return sIndex - tIndex; // found match at index
            } else if( sIndex < s.length && s[sIndex] != t[tIndex] ) {
                if(tIndex != 0) {
                    tIndex = next[tIndex - 1];
                } else {
                    sIndex++;
                }
            }
        }
        return -1;
    }
}
