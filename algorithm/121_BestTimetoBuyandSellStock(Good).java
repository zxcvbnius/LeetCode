/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction 
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Result. "Your runtime beats 84.75% of java submissions :)"
 */
 public class Solution {
    public int maxProfit(int[] prices) {
        
        int len = prices.length;
        
        int minimum  = Integer.MAX_VALUE;
        int indexMin = -1;
        int maxDiff  = 0;
        
        for(int i = 0 ; i < len ; i++) {
            int val = prices[i];
            if( minimum > val) {
                minimum  = val;
                indexMin = i; 
            } 
            int diff = val - minimum;
            if(maxDiff < diff) maxDiff = diff;
        }
        return maxDiff;
    }
}
