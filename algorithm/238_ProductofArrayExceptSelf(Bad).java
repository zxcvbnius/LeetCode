/**
 * Given an array of n integers where n > 1, nums, 
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Result. "Your runtime beats 10.67% of java submissions :("
 */
 public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product  = 1;
        int zeroCount = 0; // the # of zero
        int[] products = new int[nums.length];
        for(int i = 0; i < nums.length ; i++) {
            if(nums[i] != 0 ) {
                product *= nums[i];
            } else {
                zeroCount++;
            }
        }
        
        if(zeroCount > 1) {
            // do nothing all products are zero 
        } else if(zeroCount == 1) {
            for(int i = 0 ; i < products.length ; i++) {
                if(nums[i] == 0) products[i] = product;
                else products[i] = 0;
            }
        } else {
            for(int i = 0 ; i < products.length ; i++) {
                products[i] = product / nums[i];
            }
        }
        return products;        
    }
}
