/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * Result. "Your runtime beats 36.86% of java submissions."
 */
 
 // Sol. Find the Maximum,  Time Complexity: O(N)
public int findPeakElement(int[] nums) {
    int len = nums.length;
    if(len == 1) return 0;
    if(len  >= 2) {
        if(nums[0] > nums[1]) return 0;
        if(nums[len - 1] > nums[len - 2]) return len -1;
    }
    for(int i = 1 ; i < len -1; i++ ) {
        if( nums[i] > nums[i-1] && nums[i] > nums[i+1] ) return i;
    }
    return -1;
}

// Sol. Find the Maximum,  Time Complexity: O(N)
public class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length - 1;
        int max = Integer.MIN_VALUE;
        int maxIndex = len;
        
        while(len >= 0) {
            if(nums[len] > max) {
                max = nums[len];
                maxIndex = len;
            }
            len--;
        }
        return maxIndex;
    }
} 
 
  // Sol. Using binary search,  Time Complexity: O(logN)
 public class Solution {
    public int findPeakElement(int[] nums) {
      int len   = nums.length;
      int left  = 0;
      int right = len - 1; 
      if(len == 0) return -1;
      if(len >= 2) {
          if(nums[0] > nums[1]) return 0;
          if(nums[len - 1] > nums[len - 2]) return len -1;
      }
      while(left <= right) {
          if(left == right) return left; // or right

          int mid = (left + right) / 2;
          if(mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
              right = mid - 1;
          } else if(mid + 1 < len && nums[mid] < nums[mid + 1]) {
              left = mid + 1;
          } else {
              return mid;
          }
      }
      return -1;
  }
}
