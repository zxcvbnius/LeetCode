/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * Result. "Your runtime beats 67.25% of java submissions."
 */
 public class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        
        int commonLength = Integer.MAX_VALUE;
        
        for(int i = 1 ; i < strs.length ; i++ ) {
            String s1 = strs[i-1];
            String s2 = strs[i];
            int val = findMaxLengthOfPrefix(s1, s2);
            if(val < commonLength) commonLength = val;
        }
        return strs[0].substring(0, commonLength);
    }
    
    public int findMaxLengthOfPrefix(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int index = 0;
        
        while(index < ch1.length && index < ch2.length && ch1[index] == ch2[index] ) {
            index++;
        }
        return index;
    }
}
