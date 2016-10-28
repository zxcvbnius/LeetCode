/**
 * Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * Result. "Your runtime beats 39.67% of java submissions :("
 */
 public class Solution {
    public int[] plusOne(int[] digits) {
        
        int carry = 1;
        int len   = digits.length;
        int index = len - 1;
        
        while(index >= 0 && carry == 1) {
            int val = digits[index];
            val += 1;
            if(val == 10) {
              digits[index] = 0;
              carry       = 1;
            } else {
              digits[index] = val;  
              carry       = 0;
            }
            index --;
        }
        
        if(carry > 0) {
            int[] newDigits = new int[len+1];
            newDigits[0]  = 1;
            for(int i = 0 ; i < len ; i++) {
                newDigits[i+1]  = digits[i];
            }
            return newDigits;
        }
        return digits;
        
    }
}

/**
 * Another smarter solutions,
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >=0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
