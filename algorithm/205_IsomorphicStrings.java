/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * For example,
 *   Given "egg", "add", return true.
 *   Given "foo", "bar", return false.
 *   Given "paper", "title", return true.
 */
 
// Result. "Your runtime beats 95.96% of java submissions :)"
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length() ) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        int[] sArray  = new int[200];
        int[] tArray  = new int[200];
        
        for(int i = 0 ; i < sArray.length ; i++) {
            sArray[i] = -1;
            tArray[i] = -1;
        }
        
        for(int i = 0 ; i < sChars.length ; i++) {
            int sVal = sArray[ sChars[i] ];
            if(sVal < 0) sArray[ sChars[i] ] = tChars[i];
            else if(sArray[ sChars[i] ] != tChars[i]) return false;
            
            int tVal = tArray[ tChars[i] ];
            if(tVal < 0) tArray[ tChars[i] ] = sChars[i];
            else if(tArray[ tChars[i] ] != sChars[i]) return false;
        }
        return true;
    }
}

// Result. "Your runtime beats 97.88% of java submissions :)"
public class Solution {
    public boolean isIsomorphic(String sString, String tString) {
        char[] s = sString.toCharArray();
        char[] t = tString.toCharArray();

        int length = s.length;
        if(length != t.length) return false;

        char[] sm = new char[256];
        char[] tm = new char[256];

        for(int i=0; i<length; i++){
            char sc = s[i];
            char tc = t[i];
            if(sm[sc] == 0 && tm[tc] == 0){
                sm[sc] = tc;
                tm[tc] = sc;
            }else{
                if(sm[sc] != tc || tm[tc] != sc){
                    return false;
                }
            }
        }
        return true;
    }
}
