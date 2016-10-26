/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 **/
 
 public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len];
        
        //k = len - k;
        for(int i = 0 ; i < len ; i++) {
            res[(i+k) % len] = nums[i];
        }
        for(int i = 0 ; i < len ; i++) {
            nums[i] = res[i];
        }
        nums = res;
    }
}
