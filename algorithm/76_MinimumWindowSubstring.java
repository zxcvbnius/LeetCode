/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 *   S = "ADOBECODEBANC"
 *   T = "ABC"
 *   Minimum window is "BANC".
 * Note:
 *   If there is no such window in S that covers all characters in T, return the empty string "".
 * Result. "Your runtime beats 56.23 of java submissions."
 */
 public class Solution {
    
    int start = -1;
    int end   = -1;
    
    int mStart = -1;
    int mEnd   = -1;
    
    public String minWindow(String s, String t) {
        
        if(s == null || t == null) return "";
        if( s.length() < t.length() ) return "";
        
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        int[] tCounts = new int[256];
        int[] inRange = new int[256];
        
        for(char ch : tChars) {
            tCounts[ch]++;
        }
        
        for(int i = 0 ; i < sChars.length ; i++) {
            if( tCounts[ sChars[i] ] > 0 ) { // sChars in string t
                if(start < 0) start = i;
                inRange[ sChars[i] ]++;
                
                if( inRange[ sChars[i] ] > tCounts[sChars[i]] && sChars[i] == sChars[start] ) {
                    for(int k = start ; k < sChars.length ; k++) {
                        if( tCounts[ sChars[k] ] < inRange[ sChars[k] ] ) {
                            inRange[ sChars[k] ]--;                        
                        } else if(tCounts[ sChars[k] ] > 0) {
                            start = k;
                            break;
                        }
                    }
                }
                
                boolean hasAllAlpha = true;
                for(int j = 0 ; j < 256 ; j++) {
                    if( inRange[j] < tCounts[j]) {
                        hasAllAlpha = false;
                        break;
                    }
                }
                
                if(hasAllAlpha) {
                    end = i;
                    if(mEnd < 0 || end - start < mEnd - mStart ) {
                        mStart = start;
                        mEnd = end;
                    }
                }
            }
        }
        
        return (mEnd < 0) ? "" : s.substring(mStart, mEnd + 1);
    }
}
