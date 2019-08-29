class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> remaining = new Stack<>();

        int pushLen = pushed.length, popLen = popped.length, popIdx = 0;
        
        for(int i = 0 ; i < pushLen ; i++) {
            remaining.push( pushed[i] );
            
            while( popIdx < popLen 
                   && !remaining.isEmpty() 
                   && popped[popIdx] == remaining.peek() ) {
                popIdx++;
                remaining.pop();
            }
        }
        
        return popIdx == popLen;
    }
}
