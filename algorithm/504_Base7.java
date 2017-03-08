/**
 * Given an integer, return its base 7 string representation.
 * 
 * Example 1:
 * Input: 100
 * Output: "202"
 *  
 * Example 2:
 * Input: -7
 * Output: "-10"
 * Note: The input will be in range of [-1e7, 1e7].
 * 
 */

// Result. "Your runtime beats 14.17% of java submissions."
 public class Solution {
    public String convertToBase7(int num) {
      
      if(num == 0) return "0";    
        
      boolean isNegative = (num < 0);
      if(isNegative) num = -num;
      
      int[] bases = {1, 7, 49, 343, 2401, 16807, 117649, 823543, 5764801, 40353607, 282475249, 1977326743}; // len is 12
      
      int[] counts = new int[12];
      int index = bases.length - 1;
      int maxBit = -1;
      
      while(num > 0) {
          if( bases[index] <= num ) {
              if(maxBit < 0) maxBit = index;
              counts[index]++;
              num -= bases[index];
          } else {
              index--;
          }
      }
      
      StringBuilder sb = new StringBuilder();
      if(isNegative) sb.append("-");
      for(int i = maxBit ; i >= 0 ; i--) {
          sb.append( counts[i] );
      }
      
      return sb.toString();  
    }
}
