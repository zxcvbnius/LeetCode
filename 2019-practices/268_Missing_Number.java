class Solution {
    public int missingNumber(int[] nums) {
        // the sum of 0 ~ n  => ( 1 + n ) * n / 2
        
        if(nums == null) return -1;
        
        int len  = nums.length;
        int sum = (1 + len) * len / 2;
        
        for(int i = 0 ; i < nums.length ; i++) {
            sum -= nums[i];
        }
        
        return sum;
    }
}
