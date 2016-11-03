/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 * Result. "Your runtime beats 18.75% of java submissions."
 * Sol. Using binary search O(N)
 */
 
 public class Solution {
    public int maxArea(int[] nums) {
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        int left  = 0;
        int right = len -1;
        
        while(left <= right) {
            int area = (right - left) * Math.min(nums[left], nums[right]);
            if(area > max) max = area;
            
            if(nums[left] > nums[right]) right --;
            else if(nums[left] < nums[right]) left++;
            else left++;
        }
        return max;
    }
    
}
