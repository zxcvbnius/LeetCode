class Solution {
    public int majorityElement(int[] nums) {
        if( nums == null ) return -1; // not sure
        
        int curVal = nums[0];
        int curValCount = 1;
        int len = nums.length;
        
        for (int i = 1 ; i < len ; i++) {
            if(nums[i] != curVal) {
                curValCount--;
            } else { // equal
                curValCount++;
            }
            
            if(curValCount == 0) {
                curVal = nums[i];
                curValCount = 1;
            }
        }
        
        return curVal;
    }
}
