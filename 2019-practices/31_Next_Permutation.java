class Solution {
    public void nextPermutation(int[] nums) {
        int idx = nums.length - 2;
        while( idx >= 0 && nums[idx] >= nums[idx + 1] ) idx--;
        if( idx >= 0 ) {
            // find rightest num which is larger than nums[ idx ]
            int hi = nums.length - 1;
            while( nums[idx] >= nums[hi] ) hi--;
            int tmp = nums[idx];
            nums[idx] = nums[hi];
            nums[hi] = tmp;
        }
        
        reverse( nums, idx + 1, nums.length - 1 );
    }
    
    public void reverse(int[] nums, int lo, int hi) {
        while( lo < hi ) {
            int tmp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = tmp;
            lo++;
            hi--;
        }
    }
}
