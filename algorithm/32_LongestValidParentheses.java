/**
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 * Result. "Your runtime beats 58.43% of java submissions."
 */
public class Solution {
    public int longestValidParentheses(String s) {
        
        if(s == null ) return 0;
        int maxCount = 0, left = -1;
        
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>(); // recording index
        for(int i = 0 ; i < chars.length ; i++) {
            
            if( chars[i] == '(' ) {
                stack.push(i);
            } else if( chars[i] == ')' ) {
                if( stack.size() > 0 ) {
                    stack.pop();
                    if( stack.isEmpty() ) maxCount = Math.max(maxCount, i - left);
                    else maxCount = Math.max(maxCount, i - stack.peek());
                } else { // stack is empty
                    left = i;
                }
            }
        }
        return maxCount;
    }
}
