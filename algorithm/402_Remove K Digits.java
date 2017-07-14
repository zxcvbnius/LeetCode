/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * 
 * Note:
 *   The length of num is less than 10002 and will be ≥ k.
 *   The given num does not contain any leading zero.
 *   Example 1:
 * 
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 *  
 * Result. "Your runtime beats 37.11% of java submissions.
 */
 
 public class Solution {
    
    int k = 0;
    public String removeKdigits(String num, int step) {
        if( num.length() == step) return "0";
        
        k = step; // 很重要
        
        StringBuilder sb = new StringBuilder();
        
        char[] chars = num.toCharArray();
        int start = 0;
        
        
        StringBuilder sb1 = helper(chars, start, chars.length - 1, new StringBuilder() );
        sb.append(sb1);
        
        while(start < chars.length && start < sb.length() && sb.charAt(start) == '0') start++;
        
        return start == sb.length() || sb.length() == 0 ? "0" : sb.substring(start);
    }
    
    private StringBuilder helper(char[] chars, int start, int end, StringBuilder sb) { // include 'start' and 'end'
        Stack<Integer> stack = new Stack<>();
        for(int i = start ; i <= end ; i++) {
            int val = chars[i] - '0';
            while( k > 0 && !stack.isEmpty()  && stack.peek() > val) {
                stack.pop();
                k--;
            }
            stack.push( val );
        }
        
        while(k > 0 && !stack.isEmpty()) {
            k--;
            stack.pop();
        }
        
        while( !stack.isEmpty() ) {
            sb.append( stack.pop() );
            
        }
        
        return sb.reverse();
    }
}
