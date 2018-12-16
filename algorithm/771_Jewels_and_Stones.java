/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * 
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * 
 * Example 1:
 * 
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * 
 */
 
 // Result. "Your runtime beats 99.72% of java submissions." but this is the best solution.
class Solution {
    public int numJewelsInStones(String J, String S) {
        
        if(J == null || S == null) return 0;
        
        char[] jChars = J.toCharArray();
        char[] sChars = S.toCharArray();
        int[] words = new int[256];
        
        for(int i = 0 ; i < jChars.length ; i++) {
            words[ jChars[i] - 0 ]++;
        }
        
        int result = 0;
        for(int i = 0 ; i < sChars.length ; i++) {
            if( words[ sChars[i] - 0 ] == 1 ) {
                result++;
            }
        }
        
        return result;
    }
}
