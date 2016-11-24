/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Result. "Your runtime beats 12.10% of java submissions." (most ppl in the range)
 */
 public class Solution {
    public int climbStairs(int n) {
        
        int[] steps = new int[256];
        
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        steps[1] = 1;
        steps[2] = 2;
        
        for(int i = 3 ; i < n + 1; i++) {
            steps[i] = steps[i-1] + steps[i-2];
        }
        return steps[n];
    }
}
