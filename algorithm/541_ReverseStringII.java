/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 *   Input: s = "abcdefg", k = 2
 *   Output: "bacdfeg"
 * Restrictions:
 *   The string consists of lower English letters only.
 *   Length of the given string and k will in the range [1, 10000]
 *  
 * Result. "Your runtime beats 51.20 % of java submissions.
 */
public class Solution {
    public String reverseStr(String s, int k) {
        char[] sChars = s.toCharArray();
        int index = 0;
        while( index < sChars.length ) {
            int start = index;
            int end = index + 2*k - 1;
            if(end >= sChars.length) end = sChars.length - 1;
            
            if( (end - start + 1) - k < 0) {
                reverseChar( sChars, start, end);
            } else {
                reverseChar( sChars, start, start + k - 1);
            }
            
            index = end + 1;
        }
        
        return new String(sChars);
    }
    
    private void reverseChar(char[] chars, int start, int end) { // including chars[start] and chars[end]
        while(start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end]   = temp;
            start++;
            end--;
        }
    }
}
