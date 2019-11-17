class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        for(int i = 1 ; i <= N ; i++) {
            if( isValid(i) ) count++;
        }
        return count;
    }
    
    public boolean isValid( int num ) {
        boolean isValid = false;
        
        while( num > 0 ) {
            int remain = num % 10;
            // 2, 5, 6, 9
            if( remain == 2 ||  remain == 5 || remain == 6 || remain == 9) {
                isValid = true;
            }  // 3, 4, 7
            else if(remain == 3 ||  remain == 4 || remain == 7) {
                return false;
            }
            num /= 10;
        }
        return isValid;
    }
}
