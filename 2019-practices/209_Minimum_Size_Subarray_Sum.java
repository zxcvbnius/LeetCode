class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int s = 0, idx = 0, sum = 0, len = nums.length + 1;
        
        for(int n : nums) {
            sum += n;
            while( sum >= target ) {
                len = Math.min(len, idx - s + 1);
                sum -= nums[s];
                s++;
            }
            idx++;
        }
        
        if( sum == target) {
            
        }
        
        return len == nums.length + 1 ? 0 : len;
    }
}
