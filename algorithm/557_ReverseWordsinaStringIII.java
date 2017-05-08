/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1:
 *   Input: "Let's take LeetCode contest"
 *   Output: "s'teL ekat edoCteeL tsetnoc"
 *   Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * 
 * Result. "Your runtime beats 84.95 % of java submissions.
 */
 public class Solution {
    public String reverseWords(String s) {
        
        if(s == null || s.length() == 0) return s;
        
        char[] chars = s.toCharArray();
        
        int start = 0;
        for(int i = 0 ; i <= chars.length ; i++) {
            if( i == chars.length  || chars[i] == ' ') {
                int end = i - 1;
                while(start < end) {
                    char temp = chars[ start ];
                    chars[ start ] = chars[ end ];
                    chars[ end ] = temp;
                    start++;
                    end--;
                }
                start = i + 1;
            }
        }
        return new String( chars );
    }
}
