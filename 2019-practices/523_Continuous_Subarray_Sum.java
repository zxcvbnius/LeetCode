class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        int len = nums.length;
        if( len <= 1 ) return false;
        
        // Two continuous "0" will form a subarray 
        // which has sum = 0. 0 * k == 0 will always be true.
        for (int i = 1; i < len; i++) {
            if (nums[i-1] == 0 && nums[i] == 0) return true;
        }
        
        // At this point, k can't be "0" any longer.
        if (k == 0) return false;
        // Let's only check positive k.
        // Because if there is a n makes n * k = sum, it is always true -n * -k = sum.
        if (k < 0) k = -k;
        
        int[] preSum = new int[ len + 1];
        
        for(int i = 1 ; i <= len ; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        
        for(int i = 0 ; i <= len ; i++) {
            for(int j = i + 2 ; j <= len ; j++) {
                int val = preSum[j] - preSum[i];
                if( val != 0 && val % k == 0 ) return true;
            }
        }
        
        return false;
    }
}
