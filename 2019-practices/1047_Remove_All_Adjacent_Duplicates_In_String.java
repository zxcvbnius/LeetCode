class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();

        char[] sChars = S.toCharArray();
        for(char ch : sChars) {
            if( stack.isEmpty() ) stack.add( ch );
            else {
                if( stack.peek() == ch ) {
                    stack.pop();
                } else {
                    stack.add( ch );
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while( !stack.isEmpty() ) sb.append( stack.pop() );
        return sb.reverse().toString();
    }
}
