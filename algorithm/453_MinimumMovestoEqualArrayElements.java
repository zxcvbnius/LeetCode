/**
 * Given a non-empty integer array of size n, 
 * find the minimum number of moves required to make all array elements equal, 
 * where a move is incrementing n - 1 elements by 1.
 * 
 * Input:
 * [1,2,3]
 * 
 * Output:
 * 3
 * 
 * Explanation:
 *   Only three moves are needed (remember each move increments two elements):
 * 
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 
 * Result. "Your runtime beats 78.95% of java submissions."
 */
 public class Solution {
    public int minMoves(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        
        int min = nums[0]; // find mimimum number
        for(int i = 1 ; i < nums.length ; i++) {
            if(min > nums[i]) min = nums[i];
        }
        
        int res = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            res += nums[i] - min;
        }
        return res;
    }
}
