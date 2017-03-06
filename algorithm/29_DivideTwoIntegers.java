/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 * 
 * Result. "Your runtime beats 11.81% of java submissions."
 */
 public class Solution {
    public int divide(int dividend, int divisor) {
        long result = divideLong(dividend, divisor);
	    return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
    }
    
    private long divideLong(long dividend, long divisor) {
        // Remember the sign
        boolean isNegative = (dividend < 0) != (divisor < 0);
        
        // Make dividend and divisor unsign
        if(dividend < 0) dividend = -dividend;
        if(divisor < 0) divisor = -divisor;
        
        // Return if nothing to divide
        if(dividend < divisor) return 0;
        
        long sum = divisor;
        long divide = 1;
        while( (sum+sum) <= dividend) {
            sum += sum;
            divide += divide;
        }
        
        // Make a recursive call for (devided-sum) and add it to the result
        return isNegative ? -(divide + divideLong((dividend-sum), divisor)) :
    	(divide + divideLong((dividend-sum), divisor)); 
    }
}
