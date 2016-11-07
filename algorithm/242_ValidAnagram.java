/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *   For example,
 *     s = "anagram", t = "nagaram", return true.
 *     s = "rat", t = "car", return false.
 * Sol. Using binary search O(N)
 */
 
 // 28.79%
public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        if(s.length() != t.length()) return false;
        
        int[] sCount = new int[36];
        for(int i = 0 ; i < sChars.length ; i++) {
            sCount[ Character.getNumericValue(sChars[i]) ]++;
            sCount[ Character.getNumericValue(tChars[i]) ]--;
        }
        for(int i = 0 ; i < sCount.length; i++) {
            if(sCount[ i ] != 0) return false;
        }
        return true;
    }
}

// 87.28%
public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        if(s.length() != t.length()) return false;
        
        int[] sCount = new int[36];
        for(int i = 0 ; i < sChars.length ; i++) {
            sCount[ sChars[i] - 'a' ]++;
            sCount[ tChars[i] - 'a' ]--;
        }
        for(int i = 0 ; i < sCount.length; i++) {
            if(sCount[ i ] != 0) return false;
        }
        return true;
    }
}
