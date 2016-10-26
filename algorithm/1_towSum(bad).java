/**
  * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
  * You may assume that each input would have exactly one solution.
 **/
 
 public class Solution {
    
    public int[] twoSum(int[] nums, int tar) {
        int len = nums.length;
        int[] res = {-1, -1};
        for(int i = 0 ; i < len ; i++) {
            for(int j = i + 1; j < len; j++ ) {
                if(nums[i] + nums[j] == tar) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
            if(res[0] >= 0) break;
        }
        return res;
    }
}
