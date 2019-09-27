class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length, last = len - 1;

        for(int i = len - 2 ; i >= 0 ; i--) {
            if( i + nums[i] >= last ) last = i; 
        }
        
        return last == 0;
    }
}
