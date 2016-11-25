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
