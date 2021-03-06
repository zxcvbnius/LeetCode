class Solution {
    public int maxProfit(int[] prices) {
        int sold = 0, hold = Integer.MIN_VALUE, rest = 0;
        
        for( int p : prices ) {
            int prev_sold = sold;
            sold = hold + p;
            hold = Math.max( hold, rest - p);
            rest = Math.max( rest, prev_sold );
        }
        
        return Math.max( rest, sold );
    }
}
