/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
 * The algorithm should run in linear time and in O(1) space.
 * There are several solutions.
 */
 
 
 // Sol1. The worst solution, Quicksort + O(N) search to find all elements that appear more than ⌊ n/3 ⌋ times. 
 // Result. "Your runtime beats 38.67% of java submissions :("
 public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>(); // result
        int len = nums.length;
        if(len  == 0 ) return res;
        
        int threshold = len / 3 + 1;
        
        Arrays.sort(nums); // quick sort
        
        int current  = nums[0];
        int curCount = 1;
        for(int i = 1 ; i < len ; i++) {
            if(nums[i] == current) {
                curCount++;
            } else {
                if(curCount >= threshold) res.add(current);
                current  = nums[i];
                curCount = 1;
            }
        }
        if(curCount >= threshold) res.add(current);
        return res;
    }
}


// Sol2. Moore's voting algorithm, time complexity is O(N) and space complexity is O(1)
// Result. "Your runtime beats 58.23% of java submissions. :("
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>(); // result
        
        int candidate1, candidate2, count1, count2;
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] == candidate1) {
              count1++;
            } else if(nums[i] == candidate2) {
              count2++;
            } else if(count1 == 0) {
              candidate1 = nums[i];
              count1++;
            } else if(count2 == 0) {
              candidate2 = nums[i];
              count2++;
            } else {
              count1--;
              count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for(int i = 0 ; i < nums.length; i++) {
          if(nums[i] == candidate1) count1++;
          else if(nums[i] == candidate2) count2++;
        }
        if(count1 >= nums.length / 3 +1 ) res.add(candidate1);
        if(count2 >= nums.length / 3 +1 ) res.add(candidate2);
      
        return res;
    }
}


// Sol3. Binary Search Tree, time complexity would be O(NlogN) 
// TODO
