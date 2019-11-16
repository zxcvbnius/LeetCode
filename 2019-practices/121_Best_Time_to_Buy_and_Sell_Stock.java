class Solution {
    public int maxProfit(int[] prices) {
        if( prices == null || prices.length == 0 ) return 0;

        int min = prices[0], max = 0;
        int len = prices.length;

        for(int i = 1 ; i < len ; i++) {
            if( min > prices[i] ) {
                min = prices[i];
            } else {
                max = Math.max( max, prices[i] - min );
            }
        }
        
        return max;
    }
}
