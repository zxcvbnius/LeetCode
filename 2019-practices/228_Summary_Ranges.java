class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        int idx = 0, len = nums.length;
        while( idx < len ) {
            int start = idx;
            while( idx + 1 < len && nums[idx + 1] - nums[idx] == 1) idx++;

            if( start == idx ) {
                res.add("" + nums[start]);
                idx++;
            } else {
                res.add( "" + nums[start] + "->" + nums[idx] );
                idx++;
            }
        }
        return res;
    }
}
