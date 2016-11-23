/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * Result. "Your runtime beats 87.09% of java submissions."
 */
 public class Solution {
    public int firstUniqChar(String s) {
        if(s == null) return 0;
        char[] chars = s.toCharArray();
        int[] counts = new int[256]; // record each char counts 
        int[] index  = new int[256]; // record 'char' index in chars
        for(int i = 0 ; i < chars.length ; i++) {
            counts[ chars[i] - 0 ]++;
            index[ chars[i] - 0 ] = i;
        }
        
        int minIndex = -1;
        for(int i = 0 ; i < counts.length ; i++) {
            if( counts[i] == 1 ) {
                if(minIndex < 0 || minIndex > index[i]) minIndex = index[i];
            }
        }
        return minIndex;
    }
}
