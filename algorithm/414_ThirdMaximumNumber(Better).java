/**
 * Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * Result. "Your runtime beats 47.70% of java submissions :("
 */
 public class Solution {
    public int thirdMax(int[] nums) {
		long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
    for (int num : nums) {
        if (num > first) {
            third = second;
            second = first;
            first = num;
        } else if (num > second && num < first) {
            third = second;
            second = num;
        } else if (num > third && num < second) {
            third = num;
        }
    }
    return (int)((third == Long.MIN_VALUE || third == second) ? first : third);
	}
}
