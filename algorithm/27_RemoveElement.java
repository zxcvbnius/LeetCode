/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 **/
public class Solution {
    public int removeElement(int[] nums, int val) {
        
        int position = 0;
        int len   = nums.length;
        for(int i = 0 ; i < len; i++) {
            if(val != nums[i]) {
                nums[position] = nums[i];
                position++;
            }
        }
        return position;
    }
}
