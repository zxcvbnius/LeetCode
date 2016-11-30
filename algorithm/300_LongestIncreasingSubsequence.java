/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * 
 * Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * Result. "Your runtime beats 60.49% of java submissions."
 */
 public class Solution {
    public int lengthOfLIS(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        
        ArrayList<Integer> dp = new ArrayList<>();
        for(int num : nums) {
            if( dp.size() == 0 || dp.get(dp.size()-1) < num ) dp.add(num);
            else {
                int i = Collections.binarySearch(dp, num);
                dp.set( (i < 0) ? -i-1 : i, num );
            }
        }
        
        return dp.size();
    }
}
