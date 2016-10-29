/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * Result. "Your runtime beats 58.88% of java submissions."
 * Sol. Using binary search O(logN)
 */
 
 public class Solution {
    public int findMin(int[] nums) {
        int len   = nums.length;
        int left  = 0;
        int right = len -1;
        
        while(left <= right) {
            if(left == right) return nums[left];
            int mid = (left + right) / 2;
            if(nums[mid] < nums[right]) {
                right = mid;
            }else if(nums[mid] > nums[left]) {
                left = mid;
            } else {
                return nums[right];
            }
        }
        return nums[0];
    }
}
