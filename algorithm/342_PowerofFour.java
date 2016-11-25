/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * 
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * 
 * Result. "Your runtime beats 24.48% of java submissions."
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        while(num >= 4) {
            if(num % 4 != 0) return false;
            num = num >>> 2;
        }
        return num == 1;
    }
} 
