class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, product = 1, result = 0;
        
        if( k < 1 ) return 0;
        
        for(int i = 0 ; i < nums.length ; i++) {
            
            product *= nums[i];
            
            while( left <= i && product >= k ) {
                product /= nums[ left++ ];
            }
            result += i - left + 1;
        }
        
        return result;
    }
}
