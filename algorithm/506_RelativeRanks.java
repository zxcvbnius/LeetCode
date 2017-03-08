/**
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 * 
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 * 
 * Result. "Your runtime beats 51.80% of java submissions."
 */
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
      if(nums == null) return new String[1];
      
      int len = nums.length;
      int[] temp = new int[ nums.length ];
      for(int i = 0 ; i < nums.length ; i++) {
          temp[i] = nums[i];
      }
      // qsort
      quicksort(temp, 0, temp.length - 1);
      
      String[] results = new String[len];
      int index = len - 1;
      for(int i = temp.length - 1 ; i >= 0 ; i--) {
          if( i == temp.length - 1 ) {
            results[ getIndex(nums, temp[i]) ] = "Gold Medal";
          } else if( i == temp.length - 2 ) {
              results[ getIndex(nums, temp[i]) ] = "Silver Medal";
          } else if( i == temp.length - 3 ) {
              results[ getIndex(nums, temp[i]) ] = "Bronze Medal";
          } else {
              results[ getIndex(nums, temp[i]) ] = String.valueOf(temp.length - index);
          }
          index--;
      }
      
      return results;
    }
    
    
    private void quicksort(int[] nums, int left, int right) {
        int mid = nums[ (left + right) / 2 ];
        int low   = left;
        int high = right;
        while(left <= right) {
            while( nums[left] < mid) { left++; }
            while(nums[right] > mid) { right--; }
            if(left <= right) {
                int temp = nums[left];
                nums[left]  = nums[right];
                nums[right]  = temp;
                left++;
                right--;
            }
        }
        if(left < high) { quicksort(nums, left, high); }
        if(low < right) { quicksort(nums, low, right); }
    }
    
    private int getIndex(int[] nums, int num) {
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] == num) return i;
        }
        return -1;
    }
    
    
}
