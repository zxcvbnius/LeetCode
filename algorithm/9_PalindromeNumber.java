/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *  
 * Result. "Your runtime beats 97.33% of java submissions."
 */
 public class Solution {
    public boolean isPalindrome(int x) {
        
        if(x < 0) return false;
        
        int len = 0, num = x;
        
        while(num >= 10) {
            num /= 10;
            len ++;
        }
        len++;
        
        long base2 = (long)Math.pow(10, len - 1);
        
        for(int i = 0 ; i < len / 2 ; i++) {
            
            int val1 = x % 10;
            int val2 = (int) (x / base2);
            if(val1 != val2) return false;
            x -= val2 *  base2; 
            x /= 10;
            base2 /= 100;
        }
        return true;
        
    }
}
