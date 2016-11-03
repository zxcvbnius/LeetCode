/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * Result. "Your runtime beats 66.42% of java submissions."
 * Sol. Using binary search O(logN)
 */
 
 public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len   = nums.length;
        int left  = 0;
        int right = len - 1;
        
        if(len == 0) return new int[]{-1, -1};
        
        while(true) {
            if(left == right) {
                if(nums[left] == target) return new int[]{left, left};
                else return new int[]{-1, -1};
            } 
            int mid = (left + right) / 2;
            if(nums[mid] > target) {
                right = mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else { 
                int start = mid, end = mid;
                while(start >= 0 && nums[start] == target ) { start--; }
                start++;
                while(end < nums.length && nums[end] == target) { end++; }
                end--;
                return new int[]{start, end};
            }
        }
    }
}
