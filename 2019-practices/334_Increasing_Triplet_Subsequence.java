class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] max = new int[2];
        for(int i = 0 ; i < 2 ; i++) max[i] = Integer.MAX_VALUE;
        
        for( int n : nums ) {
            if( n <= max[0] ) max[0] = n;
            else if( n <= max[1] ) max[1] = n;
            else return true;
        }
        
        return false;
    }
}
