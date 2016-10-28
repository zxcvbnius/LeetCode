/**
 * Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
 * and the difference between i and j is at most k.
 * Result. "Your runtime beats 78.88% of java submissions :("
 * Note: You have to try "TreeSet", "HashSet", "Set", "ArrayList", ...
 */
 
 public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> fifo = new HashSet<Integer>();
    	int len = nums.length;
    	for(int i = 0 ; i < len ; i++ ) {
    		int val = nums[i];
    		if( i > k) fifo.remove(nums[i - k - 1]);
    		if( !fifo.add(val) ) return true;
    	}
    	return false;
    }
}
