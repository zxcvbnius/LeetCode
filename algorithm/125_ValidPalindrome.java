/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 *   "A man, a plan, a canal: Panama" is a palindrome.
 *   "race a car" is not a palindrome.
 * Result. "Your runtime beats 91.66% of java submissions.
 */
 // step1. Convert String to char array
public class Solution {
    public boolean isPalindrome(String s) {
        
        if(s == null ) return false;
        
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        // a: 97, z: 122, A:65, Z: 90, 0: 48, 0: 57
        while(left < right) {
            
            boolean lAlpha = isAlpha(chars[left]), lnumeric = isNumeric(chars[left]),
            rAlpha = isAlpha(chars[right]), rnumeric = isNumeric(chars[right]);
            
            if( !lAlpha && !lnumeric ) left++;
            else if( !rAlpha && !rnumeric ) right--;
            else if( lAlpha^rAlpha ) return false;
            else if( lnumeric^rnumeric ) return false;
            else {
                int val = Math.abs(chars[left] - chars[right]);
                if( lAlpha && val != 0 && val != 32 ) return false;
                if( lnumeric && val != 0 ) return false;
                left++;
                right--;                    
            }
        }
        return true;
    }
    
    
    public boolean isAlpha(char ch) {
        int val = ch - 0;
        return ( val >= 65 && val <= 90) || (val >= 97 && val <= 122);
    }
    
    public boolean isNumeric(char ch) {
        int val = ch - 0;
        return ( val >= 48 && val <= 57);
    }
}
