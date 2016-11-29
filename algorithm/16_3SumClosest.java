/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 *  Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 *     For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 *     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 */
 
 // Sol1, Time complexity O(N^2)
 // Result. "Your runtime beats 35.96% of java submissions."
 public class Solution {
    
    private int closest = Integer.MAX_VALUE;
    private int res     = 0;
    
    public int threeSumClosest(int[] nums, int target) {
        
        if(nums == null || nums.length < 3) return res;
        
        quicksort(nums, 0, nums.length - 1);
        
        for(int i = 0 ; i < nums.length ; i++) {
            int sum   = nums[i];
            int left  = i + 1;
            int right = nums.length - 1; 
            while(left < right) {
                
                sum += nums[left] + nums[right];
                
                if(sum == target) return target;
                
                int diff = sum - target;
                
                if(closest > Math.abs(diff)) {
                    closest = Math.abs(diff);
                    res     = sum;
                }
                
                sum -= (nums[left] + nums[right]);
                
                if(diff < 0) left++;
                else right--;
            }
        }
        
        return res;
    }
    
    public void quicksort(int[] nums, int left, int right) {
      int i = left, j = right, pivot = nums[(left + right) / 2];
      while(i <= j) {
          while(pivot > nums[i]) i++;
          while(pivot < nums[j]) j--;
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


 // Sol1, Time complexity O(NlogN)
 // Result. "Your runtime beats 97.68% of java submissions."
 public class Solution {
    
    private int min = Integer.MAX_VALUE;
    private int res = 0;
    
    public int threeSumClosest(int[] nums, int target) {
        
        if( nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        
        for(int i = 0 ; i < nums.length - 2 ; i++) {
            
            if( 3 * nums[i] > target ) {
                int sum = nums[i] + nums[i+1] + nums[i+2];
                if( Math.abs(sum - target) < min ) return sum;
            }
            int left  = i + 1;
            int right = nums.length - 1;
            int sum   = target - nums[i];
            
            if( 2 * nums[right] < sum ) {
                int sum2 = nums[i] + nums[right] + nums[right-1];
                if(Math.abs(sum2 - target) < min) {
                    min = Math.abs(target - sum2);
                    res = sum2;
                }
                continue;
            }
            
            while(left<right)
            {
                int temp = nums[i] + nums[left]+nums[right];
                if(temp==target) return target;
                if(2*nums[left]>sum) 
                {
                  int sumsum = nums[i]+nums[left]+nums[left+1];
                  if(Math.abs(sumsum-target)<min){
                      min = Math.abs(target-sumsum);
                      res = sumsum;
                    }
                   break;
                }
                else if(Math.abs(target-temp)<min)
                {
                    min = Math.abs(target-temp);
                    res = temp;
                }
                if(temp<target) 
                   left++;
                else right --;
            }
        }
        return res;
    }
}

