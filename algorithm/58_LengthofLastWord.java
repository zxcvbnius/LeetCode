/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * For example, 
 *   Given s = "Hello World",
 *   return 5.
 *  
 * Result. "Your runtime beats 50.22% of java submissions."
 */
 public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        
        char[] chars = s.toCharArray();
        int count = 0;
        for(int i = chars.length - 1 ; i >= 0 ; i--) {
            if(chars[i] == ' ') {
                if(count > 0) break;
            } else {
                count++;                
            }
        }
        return count;
    }
}
