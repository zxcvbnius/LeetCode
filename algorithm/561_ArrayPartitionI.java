/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * 
 * Example 1:
 * Input: [1,4,3,2]
 * 
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * Note:
 *   n is a positive integer, which is in the range of [1, 10000].
 *   All the integers in the array will be in the range of [-10000, 10000].
 */
 
// Bad, you should not use quicksort: O(nlogn)
public class Solution {
    public int arrayPairSum(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        int sum = 0;
        for(int i = 0; i < nums.length ; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
    
    private void quicksort(int[] nums, int left, int right) {
        if(left >= right) return;
        int i = left, j = right, pivot = nums[(left + right) / 2];
        while(i <= j) {
            while( pivot > nums[i] ) i++;
            while( pivot < nums[j] ) j--;
            if(i <= j) {
                int temp = nums[i];
                nums[i]  = nums[j];
                nums[j]  = temp;
                i++;
                j--;
            }
        }
        if(left < j) quicksort(nums, left, j);
        if(i < right) quicksort(nums, i, right);
    }
}
