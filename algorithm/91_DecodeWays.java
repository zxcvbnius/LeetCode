/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 *    
 */

// Dynamic Programming
// Result. "Your runtime beats 94.35% of java submissions."
public class Solution {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if(chars.length == 0) return 0;
        return dp(chars);
    }
    // Dynamic Programming
    private int dp(char[] chars) {
        int[] counts = new int[ chars.length ];
        
        counts[ chars.length - 1] = chars[chars.length - 1] == '0' ? 0 : 1;
        if(chars.length == 1) return counts[0];
        
        if(chars[chars.length - 2] == '0') {
            counts[ chars.length - 2] = 0;
        } else if (chars[chars.length - 1] == '0' && chars[chars.length - 2] - '0' > 2 ) {
            counts[ chars.length - 2] = 0;
        } else if (chars[chars.length - 1] == '0' && chars[chars.length - 2] - '0' <= 2 ) {
            counts[ chars.length - 2] = 1;
        } else if (chars[chars.length - 2] - '0' == 1 || (chars[chars.length - 2] - '0' == 2 && chars[chars.length - 1] - '0' <=6 ) ) {
            counts[ chars.length - 2] = 2;
        } else {
            counts[ chars.length - 2] = 1;
        }
        
        for(int i = chars.length - 3 ; i >= 0 ; i--) {
            if(chars[i] == '0') {
                counts[i] = 0;
            } else if(chars[i] - '0' == 1 || (chars[i] - '0' == 2 && chars[i + 1] - '0' <=6 ) ) {
                counts[i] = counts[i + 1] + counts[i + 2];
            } else {
                counts[i] = counts[i+1];
            }
        }
        return counts[0];
    }
}



// DFS - Answer is right but Time Limit Exceeded
public class Solution {
    int count = 0;
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if(chars.length == 0) return 0;
        dfs(chars, 0);
        return count;
    }
    // Answer is right but Time Limit Exceeded
    private void dfs(char[] chars, int curIndex) {
        if(chars.length == curIndex) {
            count++;
            return;
        }
        if( chars[curIndex] == '1' && curIndex + 1 < chars.length) {
            dfs(chars, curIndex + 2);
        } else if( chars[curIndex] == '2' && curIndex + 1 < chars.length && chars[curIndex+1] - '0' <= 6 ) {
            dfs(chars, curIndex + 2);
        }
        
        if(chars[curIndex] != '0') {
            dfs(chars, curIndex + 1);            
        }
    }
}
