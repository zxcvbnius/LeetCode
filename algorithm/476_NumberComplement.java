/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 * 
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * 
 * Example 1:
 *   Input: 5
 *   Output: 2
 *  
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 * Result: Result. "Your runtime beats 54.33% of java submissions." 
 **/
 
 public class Solution {
    public int findComplement(int num) {
        
        int[] array = {1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, 2147483647};
        for(int i = 0 ; i < array.length ; i++) {
        	if( num < array[i] ) {
        		return array[i] - num;
        	} else if(num == array[i] ) {
        		return 0;
        	}
        }
        return 0;
    }
}
