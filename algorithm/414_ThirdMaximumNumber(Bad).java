/**
 * Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * Result. "Your runtime beats 3.74% of java submissions :("
 */
 public class Solution {
    public int thirdMax(int[] nums) {
		String first = null, second = null, third = null;
		int len = nums.length;
		
		if(len == 1) return nums[0];
		else if(len == 2) return (nums[0] > nums[1]) ? nums[0] : nums[1] ;
		else {
			for(int i = 0 ; i < len; i++) {
				int val = nums[i];
				if(first == null || (first != null && Integer.valueOf(first) < val) ) {
					third = second;
					second = first;
					first = String.valueOf(val);
				} else if( (second == null)  || (second != null && Integer.valueOf(second) < val) ) {
					if(Integer.valueOf(first) == val) continue;
					third = second;
					second = String.valueOf(val);
				} else if( (third == null)  || (third != null && Integer.valueOf(third) < val) ) {
					if(Integer.valueOf(second) == val) continue;
					third =  String.valueOf(val);
				}
			}
		}
		if(third == null) return Integer.valueOf(first);
		else return Integer.valueOf(third);
	}
}
