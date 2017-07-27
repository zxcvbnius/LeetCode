/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Result. "Your runtime beats 46.46% of java submissions."
 */
 public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] temps = new int[ nums.length ];
        for(int i = 0 ; i < nums.length ; i++) temps[i] = nums[i];
        
        // quicksort(temps, 0 , temps.length - 1);
        Arrays.sort(temps);
        
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if( nums[i] == temps[i] ) count++;
            else break;
        }
        
        for(int i = nums.length - 1 ; i >= 0 ; i--) {
            if(nums[i] == temps[i]) count++;
            else break;
        }
        
        return nums.length - count < 0 ? 0 : nums.length - count;
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
