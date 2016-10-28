/**
 * Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * Result. "Your runtime beats 21.82% of java submissions :("
 * Because HashMap.get() => Time Complexity is O(N)
 * Quicksort have better time complexity then Map O(NlogN)
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
    	int len = nums.length;
    	for(int i = 0 ; i < len; i++ ) {
    		int val = nums[i];
    		if(map.get(val) != null) return true;
    		else map.put(val, i);
    	}
        return false;
    }
}
