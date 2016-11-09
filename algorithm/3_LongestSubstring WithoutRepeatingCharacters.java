/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 *   Given "abcabcbb", the answer is "abc", which the length is 3.
 *   Given "bbbbb", the answer is "b", with the length of 1.
 *   Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
 
// Sol1. "Your runtime beats 38.34% of java submissions."
 public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, count = 0, start = 0; 
        int[] chars = new int[256];
        char[] sChars = s.toCharArray();
        
        for(int i = 0 ; i < sChars.length ; i++) {
            int j = i;
            while(j < sChars.length) {
                char ch = sChars[j];
                if( chars[ch] == 0 ) {
                    chars[ch]++;
                    count++;
                    j++;
                } else {
                 break;   
                }
            }
            if(count > max) max = count; // reset counter
            chars = new int[256];
            count = 0;
        }
        if(count > max) max = count;
        return max;
    }
}

// To improve the solution. Using the value of chars["ch"] as the distance between the character "ch" and the start of the substring
// There are 3 situations as the following:
// 1. no duplicated character => add count
// 2. the duplicated character is the start character of current substring
// 3. the duplicated character is in the middle of the substring
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, count = 0; 
        int[] chars = new int[256];
        char[] sChars = s.toCharArray();
        
        int i = 0;
        while( i < sChars.length) {
            char ch = sChars[i];
            
            if( chars[ch] == 0 ) {
                chars[ch] = ++count;
            } else if( chars[ch] == 1) { // start from the string
                for(int j = 0 ; j < chars.length ; j++) if(chars[j] != 0) chars[j] -=1;
                chars[ch] = count;
            } else { // duplicated char is in the middle of the substring
                count = count - chars[ch] + 1;
                for(int j = 0 ; j < chars.length ; j++) {
                    if(chars[j] < chars[ch]) chars[j] = 0;
                    if(chars[j] > chars[ch]) chars[j] -= chars[ch];
                }
                chars[ch] = count;
            }
            if(count > max) max = count;
            i++;
        }
        return max;
    }
}
