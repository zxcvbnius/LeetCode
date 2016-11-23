/**
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
 * 
 * Note:
 * You may assume the greed factor is always positive. 
 * You cannot assign more than one cookie to one child.
 * 
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * Result. "Your runtime beats 43.40% of java submissions."
 */
 public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        int greed = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        
        int gIndex = 0, sIndex = 0;
        while(gIndex < g.length && sIndex < s.length) {
            if( g[gIndex] <= s[sIndex] ) {
                greed++;
                gIndex++;
                sIndex++;
            } else {
                sIndex++;
            }
        }
        return greed;
    }
}
