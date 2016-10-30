/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * Result. "Your runtime beats 58.88% of java submissions."
 * Sol. Using binary search O(N)
 */
 public class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;
        int len = prices.length;
        for(int i = 1 ; i < len; i++) {
            int diff = prices[i] - prices[i-1];
            if(diff > 0) total += diff;
        }
        return total;
    }
}
