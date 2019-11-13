class Solution {
    public boolean confusingNumber(int N) {
        int[] nums = new int[]{ 0, 1, 6, 8, 9 };
        
        int originalNum = N, res = 0;

        while( N > 0 ) {
            int val = N % 10;
            N /= 10;
            
            // not a valid integer
            if( val != 0 && val != 1 && val != 6 && val != 8 && val != 9) return false;
            
            if( val == 6 ) val = 9;
            else if(val == 9) val = 6;
            
            res = res * 10 + val;
        }
        
        return originalNum != res;
    }
}
