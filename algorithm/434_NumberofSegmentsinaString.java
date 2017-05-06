/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * Please note that the string does not contain any non-printable characters.
 * Example:
 *   Input: "  Hello,      my name is John     "
 *   Output: 5
 *   Input: "          "
 *   Output: 0
 * Result. "Your runtime beats 41.11% of java submissions.
 */
public class Solution {
    public int countSegments(String s) {
        int space = 0;
        
        if(s == null || s.isEmpty() ) return space;
        
        char[] chars = s.toCharArray();
        
        boolean allSpaces = true;
        for(char ch : chars) { if(ch != ' ') { allSpaces = false; break;} }
        if(allSpaces) return 0;
        
        int index = 0;
        while(index < chars.length && chars[index] == ' ') { chars[index] = 'a';  index++;}
        index = chars.length - 1;
        while(index >= 0 && chars[index] == ' ') { chars[index] = 'a';  index--;}
        
        
        for(int i = 0 ; i < chars.length ; i++) {
            if(chars[i] == ' ') {
                space++;
                while(chars[i] == ' ' ) {i++;}
            }
        }
        
        return space + 1;
    }
}
