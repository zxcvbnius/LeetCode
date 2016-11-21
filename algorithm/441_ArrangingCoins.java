/**
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * Result. "Your runtime beats 82.90% of java submissions :("
 */
 public class Solution {
    public int arrangeCoins(int n) {
        // (1 + line) * line / 2 => totals
        long val = (long) Math.floor( Math.sqrt(2) * Math.sqrt(n) );
        if( (1 + val) * val / 2 > n ) val--;
        return (int)val;
    }
}
