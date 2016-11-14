/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * For example,
 * 
 *   Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 *   Return:
 *   ["AAAAACCCCC", "CCCCCAAAAA"].
 * Result. "Your runtime beats 89.12% of java submissions."
 */
 public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
      List<String> res = new ArrayList<>();
      int len = s.length();
      if(len < 10) return res;
      
      Set<String> subStrings = new HashSet<String>();
      Set<String> dupSub     = new HashSet<String>();
      
      for(int i = 0 ; i <= len - 10; i++) {
          String sub = s.substring(i, i + 10);
          if( subStrings.contains(sub) ) {
              dupSub.add(sub);
          } else {
              subStrings.add(sub);
          }
      }
      
      res.addAll(dupSub);
      return res;
    }
    
}
