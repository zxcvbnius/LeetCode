/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * 
 * Example 1:
 *   Given s = "hello", return "holle".
 * 
 * Example 2:
 *   Given s = "leetcode", return "leotcede".
 * 
 * Result. "Your runtime beats 66.77% of java submissions
 **/
 public class Solution {
    public String reverseVowels(String s) {
        // vowels: a e i o u A E I O U
        if(s == null) return null;
        char[] chars = s.toCharArray();
        int len = chars.length, left = 0, right = len - 1;
        while(left < right) {
            if( !isVowel(chars[left]) ) left++;
            else if( !isVowel(chars[right]) ) right--;
            else {
                char temp    = chars[left];
                chars[left]  = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
    
    public boolean isVowel(char ch) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for(int i = 0 ; i < vowels.length ; i++) {
            if( vowels[i] == ch ) return true;
        }
        return false;
    }
}
