/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * 
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *  Example 1:
 *    Input: "USA"
 *    Output: True  
 * 
 *  Example 2:
 *    Input: "FlaG"
 *    Output: False
 * 
 * Result. "Your runtime beats 44.14% of java submissions."
 */
 public class Solution {
    public boolean detectCapitalUse(String word) {
        if(word == null) return false;
        if(word.length() == 1) return true;
        
        char[] chars = word.toCharArray();
        boolean firstIsCapital  = (chars[0] - 'A' <= 25);
        boolean secondIsCapital = (chars[1] - 'A' <= 25); 
        
        if(!firstIsCapital && secondIsCapital) return false;
        
        boolean AllneedCapital  = (firstIsCapital && secondIsCapital);
        
        for(int i = 1 ; i < chars.length ; i++) {
            boolean isCapital = ( chars[i] -  'A' <= 25);
            if(AllneedCapital && !isCapital) return false;
            if(!AllneedCapital && isCapital) return false;
        }
        return true;
        
    }
}
