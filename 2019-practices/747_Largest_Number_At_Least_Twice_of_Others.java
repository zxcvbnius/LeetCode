class Solution {
    public int dominantIndex(int[] nums) {
        int maxIdx = -1, maxVal = -1;
        for(int i = 0 ; i < nums.length ; i++) {
            if( nums[i] > maxVal ) {
                maxIdx = i;
                maxVal = nums[i];
            }
        }
        
        for(int i = 0 ; i < nums.length ; i++) {
            if( i != maxIdx && nums[i] * 2 > maxVal ) return -1;
        }
        
        return maxIdx;
    }
}
