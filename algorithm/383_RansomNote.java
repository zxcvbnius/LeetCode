/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note:
 *   You may assume that both strings contain only lowercase letters.
 * 
 *   canConstruct("a", "b") -> false
 *   canConstruct("aa", "ab") -> false
 *   canConstruct("aa", "aab") -> true
 * 
 * Result. "Your runtime beats 95.27% of java submissions."
 */
 public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine == null || ransomNote == null) return false;
        else if(ransomNote.length() == 0) return true;
        else if(magazine.length() == 0) return false;
        
        char[] m = magazine.toCharArray();
        char[] r = ransomNote.toCharArray();
        
        int[] count = new int[256];
        
        int rIndex = 0, mIndex = 0;
        while(rIndex < r.length) {
            count[ r[rIndex] - 0 ]++;
            rIndex++;
        }
        
        while(mIndex < m.length) {
            count[ m[mIndex] - 0]--;
            mIndex++;
        }
        
        for(int i = 0 ; i < count.length ; i++) {
            if(count[i] > 0) return false;
        }
        
        return true;
    }
}
