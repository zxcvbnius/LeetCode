/**
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * Result. "Your runtime beats 20.06% of java submissions."
 */
 public class Solution {
    public boolean isPowerOfTwo(int n) {
        
        if(n == 0) return false;
        if(n == 1) return true;
        if(n < 0 ) return false;
        
        while(n >= 2) {
            if(n % 2 != 0) return false;
            n = n / 2;
        }
        return true;
    }
}
