/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note:
 * 0 ≤ x, y < 231.
 * Example:
 * 
 * Input: x = 1, y = 4
 * 
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 
 * The above arrows point to positions where the corresponding bits are different.
 **/

// Result: Result. "Your runtime beats 51.9% of java submissions." 
public class Solution {
    public int hammingDistance(int x, int y) {
        
        /*long res = x^y; // very slowly "Your runtime beats 19% of java submissions."
		int count = 0;
		while(res > 0) {
			if( res % 2 == 1) count++;
			res = res >> 1;
		}
		return 0;*/
        
		return Integer.bitCount(x ^ y);
    }
}

// Result: Result. "Your runtime beats 31% of java submissions." 
public class Solution {
    public int hammingDistance(int x, int y) {
        int xlen = 0, ylen = 0;
		int[] xArray = new int[32];
		int[] yArray = new int[32];
		
		while(x > 0 || y > 0) {
			if(x > 0) {
				xArray[xlen] = (x % 2);
				xlen++;
				x /= 2;
			}
			
			if(y > 0) {
				yArray[ylen] = (y % 2);
				ylen++;
				y /= 2;
			}
		}
		
		int count = 0;
		if(xlen > ylen) count = getDiff(xArray, yArray, xlen, ylen);
		else count = getDiff(yArray, xArray, ylen, xlen);
		
		return count;
    }
    
    public int getDiff(int[] lArray, int[] sArray, int llen, int slen) {
		int diff = 0;
		for(int i = 0 ; i < llen ; i++) {
			if(lArray[i] != sArray[i] ) diff++;
		}
		return diff;
	}
}
