class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for( char ch : s.toCharArray() ) {
            if( ch == '(' || ch == '{' || ch == '[' ) {
                stack.add( ch );
            } else {
                if( stack.isEmpty() ) return false;
                char prevCh = stack.pop();
                if( ch == ')' && prevCh != '(') return false;
                if( ch == '}' && prevCh != '{') return false;
                if( ch == ']' && prevCh != '[') return false;
            }
        }
        
        return stack.isEmpty();
    }
}
