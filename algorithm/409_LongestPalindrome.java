/**
 * Given a string which consists of lowercase or uppercase letters, 
 * find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Assume the length of given string will not exceed 1,010.
 *  Input:
 *    "abccccdd"
 *  Output:
 *    7
 *  Explanation:
 *    One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Result. "Your runtime beats 55.96% of java submissions :("
 */
 public class Solution {
    public int longestPalindrome(String s) {
        int len = s.length();
        int[] chars = new int[80];
        int res = 0;
        int mid = 0;
        for(int i = 0 ; i < len ; i++ ) {
            char ch   = s.charAt(i);
            int index = Character.getNumericValue( ch );
            if( !Character.isDigit(ch) && Character.isUpperCase(ch) ) {
                index += 26;
            }
            chars[ index ]++;
        }
        for(int i = 0 ; i < chars.length ; i++) {
            res += chars[i] / 2;
            if(mid == 0 && chars[i] % 2 == 1) mid = 1;
        }
        return res*2 + mid;
    }
}
