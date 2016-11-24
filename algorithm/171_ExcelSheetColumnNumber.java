/**
 * Related to question Excel Sheet Column Title
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28 
 * 
 * Result. "Your runtime beats 12.55% of java submissions."
 */
 public class Solution {
    public int titleToNumber(String s) {
       int res = 0;
       if(s == null) return res;
       char[] chars = s.toCharArray();
       int len = chars.length, base = 1;
       for(int i = len - 1 ; i >= 0 ; i-- ) {
           res += base * (chars[i] - 64);
           base *= 26;
       }
       return res;
    }
    /*
    public int getValue(char ch) {
        return ch - 65 + 1;
        // A: 65 ~ Z: 90
    }*/
}
