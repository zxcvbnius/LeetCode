/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 * 
 * Result. "Your runtime beats 65.45% of java submissions."
 */
 public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        ArrayList<Integer> res = new ArrayList<>();
        
        if(nums == null) return res;
        
        for(int n : nums) {
            n = Math.abs(n);
            if( nums[ n - 1] > 0 ) nums[n-1] = -nums[n-1];
            else {
                res.add(n);
            }
        }
        
        return res;
    }
}
