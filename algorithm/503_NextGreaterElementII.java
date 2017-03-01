/**
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 * 
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2; 
 * The number 2 can't find next greater number; 
 * The second 1's next greater number needs to search circularly, which is also 2.
 */
 // Result. "Your runtime beats 44.89% of java submissions."
 // Time complexity is O(N)
 public class Solution {
   public int[] nextGreaterElements(int[] nums) {
          int n = nums.length;
          int[] result = new int[n];

          Stack<Integer> stack = new Stack<>();
          for (int i = n - 1; i >= 0; i--) {
              stack.push(i);
          }

          for (int i = n - 1; i >= 0; i--) {
              result[i] = -1;
              while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                  stack.pop();
              }
              if (!stack.isEmpty()){
                  result[i] = nums[stack.peek()];
              }
              stack.add(i);
          }

          return result;
      }
} 
// Result. "Your runtime beats 5.89% of java submissions."
// Time complexity is O(N^2)
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] results = new int[len];
        for(int i = 0 ; i < len; i++) {
            results[i] = -1;
        }
        for(int i = 0 ; i < len; i++) {
            int index = (i + 1) % len;
            int val   = nums[i];
            while(index != i) {
                if(nums[index] > val) {
                    results[i] = nums[index];
                    break;
                }
                index = (index + 1) % len;
            }
        }
        return results;
    }
}
