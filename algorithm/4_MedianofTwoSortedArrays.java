/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Result. "Your runtime beats 79.98%of java submissions."
 */
 public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // merge two sorted arrays into one sorted array
        int index1 = 0;
        int index2 = 0;
        
        int[] nums = new int[nums1.length + nums2.length];
        int index  = 0;
        
        if(nums1.length == 0 && nums2.length == 0) return 0;
        
        while(true) {
            if(index1 >= nums1.length && index2 >= nums2.length) break;
            
            if(index1 < nums1.length && index2 < nums2.length) {
                if(nums1[index1] > nums2[index2]) {
                    nums[index] = nums2[index2];
                    index2++;
                } else {
                    nums[index] = nums1[index1];
                    index1++;
                }
                index++;
            } else if(index1 < nums1.length && index2 >= nums2.length) { // if num2 is exhausted
                nums[index] = nums1[index1];
                index1++;
                index++;    
            } else if(index2 < nums2.length && index1 >= nums1.length) { // if num1 is exhausted
                nums[index] = nums2[index2];
                index2++;
                index++;    
            }
        }
        if(index % 2 == 1) return nums[index/2];
        else return 1.0*(nums[index/2] + nums[index/2 - 1]) / 2;
    }
}
