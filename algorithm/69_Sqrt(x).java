/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * Result. "Your runtime beats 9.44%  of java submissions."
 */
 public class Solution {
    public int mySqrt(int x) {
        double guess = x;
        while(Math.abs(guess * guess - x) >= 0.1) {
            // Next Guess = ( ( Guess^2) + N ) / ( 2 × Guess )
            guess = (guess*guess + x) / (2*guess);
        }
        return (int)Math.floor(guess);
    }
}
