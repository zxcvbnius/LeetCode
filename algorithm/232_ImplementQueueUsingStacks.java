/**
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * 
 * Result. "Your runtime beats 98.79% of java submissions."
 */
 
class MyQueue {
    
    private ArrayList<Integer> nums = new ArrayList<>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        nums.add(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        nums.remove(0);
    }

    // Get the front element.
    public int peek() {
        return nums.get(0);
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return nums.size() == 0;
    }
}

// Standard Solution
class MyQueue {
    
    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();
    
    // Push element x to the back of queue.
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        output.pop();
    }

    // Get the front element.
    public int peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return input.empty() && output.empty();
    }
}
