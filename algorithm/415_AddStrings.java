/**
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 * Result. "Your runtime beats 65.10% of java submissions."
 */
 public class Solution {
    public String addStrings(String num1, String num2) {
        return getSum( num1.toCharArray(), num2.toCharArray() );
    }
    
    public String getSum(char[] l, char[] s) {
        
        StringBuilder builder = new StringBuilder();
        boolean carry = false;
        int lIndex = l.length - 1, sIndex = s.length - 1;
        while(lIndex >= 0 || sIndex >= 0) {
            
            int val = (carry ? 1 : 0);
            if(lIndex >= 0) val += (l[lIndex] - 48);
            if(sIndex >= 0) val += (s[sIndex] - 48);
            if(val >= 10) {
                carry = true;
                val %= 10;
                builder.append(val);
            } else {
                carry = false;
                builder.append(val);
            }
            sIndex--;
            lIndex--;
        }
        
        if(carry) builder.append(1);
        return builder.reverse().toString();
    }
    
}
