/**
 * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.
 * 
 * Example 1:
 *   Input: [1,1,2,3,3,4,4,8,8]
 *   Output: 2
 * Example 2:
 *   Input: [3,3,7,7,10,11,11]
 *   Output: 10
 * Note: Your solution should run in O(log n) time and O(1) space.
 * 
 * Result. "Your runtime beats 16.82% of java submissions."
 */
 
 public class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        // binary search
        int n = nums.length, lo = 0, hi = n / 2;
        while(lo < hi) {
            int m = (lo + hi) / 2;
            if( nums[2 * m] != nums[ 2 * m + 1] ) hi = m;
            else lo = m + 1;
        }
        return nums[ 2 * lo];
        
        /*int sum = 0; // O(n)
        
        for(int n : nums) {
            sum ^= n;
        }
        return sum;*/
    }
}
