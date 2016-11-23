/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB 
 * 
 * The same letter cell may not be used more than once.
 * Result. "Your runtime beats 10.98% of java submissions." Runtime: 0ms
 */
 public class Solution {
    public String convertToTitle(int n) {
        
        StringBuilder s = new StringBuilder();
        while( n > 0 ) {
            int remainder = n % 26; // 0 ~ 25
            n /= 26;
            if( remainder == 0) {
                remainder = 26;
                n--;
            }
            s.insert(0, getChar(remainder) );
        }        
        return new String(s);
    }
    
    public char getChar(int val) {
        return Character.toChars(64 + val)[0];  // A: 65, Z: 90
    }
}
