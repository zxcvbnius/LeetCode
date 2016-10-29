/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * Result. "Your runtime beats 13.88% of java submissions."
 * Sol. Time complexity: O(N)
 */
 
public class Solution {
    public int maxProduct(int[] nums) {
        
        int len = nums.length;
        int minProduct = nums[0], maxProduct = nums[0], res = nums[0];
        
        for(int i = 1 ; i < len; i++) {
            if(nums[i] < 0) {
                int temp   = minProduct;
                minProduct = maxProduct;
                maxProduct = temp;
            }            
             maxProduct = Math.max(nums[i], nums[i] * maxProduct);
             minProduct = Math.min(nums[i], nums[i] * minProduct);
             
             res = Math.max(res, maxProduct);
        }
        return res;
    }
}
