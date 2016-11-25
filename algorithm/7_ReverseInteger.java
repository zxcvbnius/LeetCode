/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * Result. "Your runtime beats 74.06% of java submissions."
 */
 // It could happend overflow
 public class Solution {
    public int reverse(int num) {
        
        long[] nums = new long[256];
        int count  = 0;
        
        long x = num;
        
        boolean isNegative = (x < 0);
        x = Math.abs(x);
        while(x >= 10) {
            long val = x % 10;
            x /= 10;
            nums[count] = val;
            count++;
        }
        nums[count] = x;
        
        long res = 0, base = 1;
        for(int i = count ; i >= 0 ; i--) {
            res += base * nums[i];
            base*= 10;
        }
        if(!isNegative && res > Integer.MAX_VALUE) res = 0;
        if(isNegative && -res < Integer.MIN_VALUE) res = 0;
        return (int)((isNegative) ? -res : res);
    }
}
