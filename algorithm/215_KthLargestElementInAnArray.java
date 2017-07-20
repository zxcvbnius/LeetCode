/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * 
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Result. "Your runtime beats 84.72% of java submissions."
 */
 public class Solution {
    public int findKthLargest(int[] nums, int k) {
        quicksort(nums, 0, nums.length - 1);
        return nums[ nums.length - k];
    }
    private void quicksort(int[] nums, int left, int right) {
        int low = left, high = right, pivot = nums[(left + right) / 2];
        while(low < high) {
            while( nums[low] < pivot ) low++;
            while(nums[high] > pivot ) high--;
            if(low <= high) {
                int temp   = nums[low];
                nums[low]  = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        }
        if(low <  right) quicksort(nums, low, right);
        if(left < high ) quicksort(nums, left, high);
    }
}
