/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * Result. "Your runtime beats 75.94%  of java submissions."
 * Sol. Using binary search O(logN)
 */
 public class Solution {
    public int searchInsert(int[] nums, int target) {
        int len   = nums.length;
        int left  = 0;
        int right = nums.length - 1;
        if(len == 0) return 0;
        while(true) {
            if(left == right) {
                if(nums[left] > target) {
                    return left;
                } else if(nums[left] < target) {
                    return left + 1;
                } else {
                    return left;
                }
            }
            int mid = (left + right) / 2;
            
            if(nums[mid] > target) {
                right = mid;
            } else if(nums[mid] < target) {
                left = mid + 1;                
            } else {
                return mid;
            }
        }
    }
}

