/**
  * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
  * You may assume that each input would have exactly one solution.
 **/
 
public static class Solution {
		public int[] twoSum(int[] nums, int tar) {
			HashMap<Integer, Integer> maps = new HashMap<>(); // value, index
			int len = nums.length;
			for(int i = 0 ; i < len ; i++) {
				if(maps.get(tar - nums[i]) != null ) { // it means we have found 'tar-nums[i]' before
					int[] res = {maps.get(tar - nums[i]), i};
					return res;
				} else {
					maps.put(nums[i],i);// store value and index in map
				}
			}
			return null;
    }
}
