/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 * 
 * Example 1:
 *   Input: [3, 1, 4, 1, 5], k = 2
 *   Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 *   Input:[1, 2, 3, 4, 5], k = 1
 *   Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 */
public class Solution {
    public int findPairs(int[] nums, int k) {
        
        if(nums == null || nums.length == 0 || k < 0) return 0;
        
        int count = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums) {
            map.put(n, map.get(n) == null ? 1 : map.get(n) + 1);
        }
        
        if(k == 0) {
            for(int n : nums) {
                if( map.get(n) > 1) {
                    map.put(n, 1);
                    count++;
                }
            }
        } else {
            for(int n: nums) {
                if( map.get(n - k) != null ) {
                    map.put(n - k, null);
                    count++;
                }
            }
        }
        
        return count;
    }
}
