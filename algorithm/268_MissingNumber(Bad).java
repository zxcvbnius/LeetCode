/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * Result. "Your runtime beats 43.67% of java submissions :("
 */
 public class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum   = (0 + (len) ) * (len+1) / 2;
        int count = 0;        
        for(int i = 0 ; i < len ; i++ ) {
            count += nums[i];
        }
        
        if(count - sum == 0) return 0;
        else return sum - count; 
    }
}

// Another solutions with the wrost time complexity O(logN)
// "Your runtime beats 11.67% of java submissions."
// (1)
public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length; i++) {
            if(nums[i] != i) return i;
        }        
        return nums.length;
    }
}

// (2) XOR, having the wrost time complexity too
// "Your runtime beats 11.67% of java submissions." 
public class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i = 0 ; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }        
        return res;
    }
}
