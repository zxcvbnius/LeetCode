class Solution {
    public int splitArray(int[] nums, int m) {

        int max = Integer.MIN_VALUE, group = m, sum = 0;
        for( int num : nums ) {
            if( max < num ) max = num;
            sum += num;
        }

        if( m == 1) return sum;

        // binary search
        int lo = max, hi = sum + 1;
        while( lo <= hi ) {
            int piviot = (hi + lo) / 2;
            if( valid(nums, group, piviot) ) {
                hi = piviot - 1;
            } else {
                lo = piviot + 1;
            }
        }

        return lo;
    }

    public boolean valid(int[] nums, int group, int piviot) {
        int groupCount = 1;
        int cur = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            cur += nums[i];

            if( cur > piviot ) {
                cur = nums[i];
                groupCount++;
                if( groupCount > group ) return false;
            }
        }
        return true;
    }
}
