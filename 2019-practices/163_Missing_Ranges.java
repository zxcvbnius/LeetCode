class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if( nums == null || nums.length == 0) {
            res.add( formRange(lower, upper) );
            return res;
        }
        
        // first step
        if( nums[0] > lower ) {
            res.add( formRange(lower, (long)nums[0] - 1) );
        }
        
        // second step
        for(int i = 1 ; i < nums.length ; i++) {
            if( nums[i] > (long)nums[i - 1] + 1 ) {
                res.add( formRange(nums[i - 1] + 1, nums[i] - 1) );
            }
        }
        
        // third step
        if( nums[ nums.length - 1] < upper ) {
            res.add( formRange((long)nums[ nums.length - 1] + 1, upper) );
        }
        return res;
    }
                    
    public String formRange(long lo, long hi) {
        if( lo == hi) return String.valueOf( lo );
        return String.format("%d->%d", lo, hi);
    }
}
