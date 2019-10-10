class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] cached = new int[ len * 2];
        for(int i = 0 ; i < len ; i++) {
            cached[i] = cached[i + len] = nums[i];
        }
        
        int[] ans = new int[ len ];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = len * 2 - 1; i >= 0 ; i--) {
            while( !stack.isEmpty() && stack.peek() <= cached[i] ) stack.pop();
            if(stack.isEmpty()) {
                if(i < len ) ans[i] = -1;
            } else {
                if(i < len ) ans[i] = stack.peek();
            }
            stack.push( cached[i] );
        }
        
        return ans;
    }
}
