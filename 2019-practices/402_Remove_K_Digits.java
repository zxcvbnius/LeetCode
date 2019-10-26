// slow
class Solution {
    public String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        
        Stack<Character> stack = new Stack<>();
        
        int idx = 0, len = chars.length ;
        if( k >= len) return "0";
        
        while( idx < len ) {
            while( k > 0 && !stack.isEmpty() && stack.peek() > chars[idx] ) {
                stack.pop();
                k--;
            }
            stack.push( chars[idx] );
            idx++;
        }
        
        while( k > 0 ) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while( !stack.isEmpty() ) {
            sb.append( stack.pop() );
        }
        
        sb.reverse();
        // remove zero
        while(sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        
        return sb.toString();
    }
}

// fast
class Solution {
    public String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        
        int idx = 1, len = chars.length ;
        
        if( k >= len) return "0";
        
        while( k > 0 && idx < len) {
            int s = idx - 1;
            while( k > 0 && s >= 0 ) {
                if(chars[s] == '-') {
                    s--;
                    continue;
                }
                if(chars[idx] >= chars[s]) {
                    break;
                }
                chars[s] = '-';
                k--;
                s--;
            }
            idx++;
        }
        
        idx = len - 1;
        while( k > 0 && idx >= 0 ) {
            if( chars[idx] != '-' ) {
                chars[idx] = '-';
                k--;
            }
            idx--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(char ch : chars) {
            if( sb.length() == 0 && ch == '0' ) continue;
            if( ch == '-') continue;
            sb.append(ch);
        }
        
        return sb.length() > 0 ? sb.toString() : "0";
    }
}
