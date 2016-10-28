/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Result. "Your runtime beats 40.66%  of java submissions :("
 */
 public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count  = m + n - 1;
        int index1 = m - 1;
        int index2 = n - 1;
        
        while(count >= 0) {
            if(index2 < 0) {
                nums1[count] = nums1[index1];
                index1--;
            } else if(index1 < 0) {
                nums1[count] = nums2[index2];
                index2--;
            } else {
                if( nums2[index2] > nums1[index1] ) {
                    nums1[count] = nums2[index2];
                    index2--;
                } else {
                    nums1[count] = nums1[index1];
                    index1--;
                }                
            }
            count--;
        }
    }
}
