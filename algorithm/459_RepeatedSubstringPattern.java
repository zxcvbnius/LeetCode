/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * 
 * Example 1:
 * Input: "abab"
 * Output: True
 * 
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * Input: "aba"
 * Output: False
 */

// Using char array
// Result. "Your runtime beats 43.87% of java submissions."
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s == null) return false;
        
        int len = s.length();
        int maxLen = 0;
        int beginIndex = 0;
        char[] chars = s.toCharArray();
        
        int limit = chars.length / 2 + (chars.length % 2);
        for(int i = 1 ; i <= limit ; i++) {
            if( len % i == 0) {
                if( isPattern(chars, i) && i < chars.length ) return true;
            }
        }
        return false;
    }
    private boolean isPattern(char[] chars, int subLen) {
        int len = chars.length;
        for(int i = 0 ; i < len ; i++) {
            if( chars[i] != chars[i % subLen] ) return false;
        }
        return true;
    }
}
 
 // Using substring
 // Result. "Your runtime beats 21.89% of java submissions."
 public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s == null) return false;
        
        int len = s.length();
        int maxLen = 0;
        int beginIndex = 0;
        
        for(int i = 1 ; i <= len/2 + 1 ; i++) {
            if( len % i == 0) {
                String substring = s.substring(0, i);
                if( isPattern(s, substring) && substring.length() < s.length() ) return true;
            }
        }
        return false;
    }
    private boolean isPattern(String s, String substring) {
        // System.out.println("s : " + s + ", sb : " + substring);
        int len = substring.length();
        for(int i = 0 ; i < s.length() ; i++) {
            if( s.charAt(i) != substring.charAt( i % len) ) return false;
        }
        return true;
    }
}
