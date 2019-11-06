class Solution {
    public int findLengthOfLCIS(int[] nums) {

        if( nums == null || nums.length == 0  ) return 0;
        int maxLen = 0, count = 0, curNum = nums[0];
       
       for( int n : nums ) {
           if( curNum < n ) count++;
           else {
             count = 1;
           }
           curNum = n;
           maxLen = Math.max( maxLen, count );
       }
       return maxLen;
    }
}

