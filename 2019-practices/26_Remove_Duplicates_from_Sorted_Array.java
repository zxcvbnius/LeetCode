class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int len = nums.length;

        int curIndex = 0;
        int curVal = nums[0];
        
        int count = 1; // nums[0]
        
        for(int i = 1 ; i < len ; i++) {
            if(curVal == nums[i] ) continue;
            
            curIndex++;
            nums[ curIndex ] = nums[i];
            curVal = nums[i];
            count++;
        }
        
        return count;
        
    }
}
