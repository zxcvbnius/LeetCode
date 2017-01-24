/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Result. "Your runtime beats 85.57% of java submissions."
 */
 
 public class Solution {
    public String countAndSay(int n) {
        String string = "1";
        for(int i = 0 ; i < n - 1 ; i++) {
            string = getAws(string);
        }
        return string;
    }
    
    public String getAws(String string) {
        StringBuilder builder = new StringBuilder();
        char[] chars = string.toCharArray();
        char curChar = chars[0];
        int curIndex = 0;
        for(char ch : chars) {
        	if(curChar == ch) {
        		curIndex++;
        	} else {
        		builder.append(curIndex);
        		builder.append(curChar);
        		curChar  = ch;
        		curIndex = 1;
        	}
        }
        
        builder.append(curIndex);
        builder.append(curChar);
        
        return builder.toString();
    }
}
