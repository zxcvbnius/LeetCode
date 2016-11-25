/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * Result. "Your runtime beats 72.12% of java submissions."
 */
 public class Solution {
    public boolean isValid(String s) {
        
        if(s == null) return true;
        
        char[] ch = s.toCharArray();
        
        Stack<Character> stack = new Stack<>();
        
        char[] check1 = {'(', '{', '['};
        char[] check2 = {')', '}', ']'};
        
        for(char c : ch) {
            
            int index1 = getIndexOf(check1, c);
            int index2 = getIndexOf(check2, c);
            
            if( index1 >= 0 ) stack.push(c);
            else if( index2 >= 0 ) {
                
                if(stack.isEmpty()) return false;
                
                int popIndex = getIndexOf(check1, stack.pop());
                if(index2 != popIndex) return false;
            }
        }
        
        return stack.size() == 0;
    }
    
    public int getIndexOf(char[] ch, char c) {
        for(int i = 0 ; i < ch.length ; i++) {
            if( ch[i] == c ) return i;
        }
        return -1;
    }
}
