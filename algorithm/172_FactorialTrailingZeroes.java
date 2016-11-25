/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity. 
 * 
 * Result. "Your runtime beats 37.61% of java submissions."
 */
 public class Solution {
    public int trailingZeroes(int n) {
        long base  = 5;
        int count = 0;
        while( n >= base ) {
            count += ( n / base);
            base *= 5;
        }
        return count;
    }
}
