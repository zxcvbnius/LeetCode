/**
 * Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
 * and the difference between i and j is at most k.
 * Result. "Your runtime beats 39.67% of java submissions :("
 */
 public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
      HashMap<Integer, Integer> map = new HashMap<>();
    	int len = nums.length;
    	for(int i = 0; i < len ; i++) {
    		int val = nums[i];
    		if(map.containsKey(val)) {
    			int index = map.get(val);
    			if(i - index <= k) return true;
    			else {
    				map.put(val, i); 
    			}
    		} else {
    			map.put(val, i);
    		}
    	}
    	return false;
    }
}
