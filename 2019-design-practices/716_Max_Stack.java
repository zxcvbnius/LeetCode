class MaxStack {
    
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if( maxStack.isEmpty() || maxStack.peek() <= x ) {
            maxStack.push(x);
        }
    }
    
    public int pop() {
        int x = stack.pop();
        if( x == maxStack.peek() ) maxStack.pop();
        return x;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int x = maxStack.peek();
        
        Stack<Integer> tmp = new Stack<>();
        while( x != stack.peek() ) {
            tmp.push( stack.pop() );
        }
        
        maxStack.pop();
        stack.pop();
        
        while( !tmp.isEmpty() ) {
            push(tmp.pop());
        }
        
        return x;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
