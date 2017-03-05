/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 
 * Result. "Your runtime beats 81.67% of java submissions."
 */
public class Solution {
    
    private int maxLength = 1;
    private int maxIndex = 0;
    //O(N^2), space O(1)
    public String longestPalindrome(String str) { 
        int length = str.length();
        for (int i=0; i<length; i++) {
            findPalindrome(str, length, i, 0);
            findPalindrome(str, length, i, 1);
        }
        return str.substring(maxIndex, maxIndex+maxLength);
    }

    private void findPalindrome(String str, int length, int i, int shift) {
        int left = i;
        int right= i+shift;
        while (left >= 0 && right < length && str.charAt(left) == str.charAt(right)) {
            if ((right - left + 1) > maxLength) {
                maxLength = right - left + 1;
                maxIndex = left;
            }
            left--;
            right++;
        }
   }
}
