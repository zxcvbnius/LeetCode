/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * 
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * 
 * Result. "Your runtime beats 13.80 % of java submissions."
 */

public class Solution {
    public int[] countBits(int num) {
        
        int[] res = new int[ num + 1];
        for(int i = 0 ; i <= num ; i++) {
            res[i] = getBitCount(i);
        }
        return res;
    }
    private int getBitCount(int num) {
        int count = 0;
        while( num > 0) {
            int val = num & 1;
            count  += val;
            num >>= 1;
        }
        return count;
    }
}
