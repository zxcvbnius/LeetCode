/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Result. "Your runtime beats 69.88% of java submissions."
 */
 public class Solution {
    
    int res = 0;
    Set<Integer> sets = new HashSet<>();
    
    public int longestConsecutive(int[] nums) {
        
        for(int n : nums) {
            sets.add(n);    
        }
        
        for(int n : nums) {
            if(sets.contains(n) && !sets.contains(n-1) ) { // start from n
                int m = n;
                while( sets.contains(m) ) m++;
                res = Math.max(res, m - n);
            }
        }
        
        return res;
    }
}
