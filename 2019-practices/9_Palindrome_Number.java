class Solution {
    public boolean isPalindrome(int x) {
        if( x < 0 || x % 10 == 0 && x > 0) return false;
        
        int base = getBase(x);
        int[] val = new int[ base ];
        int idx = 0;
        while( x > 0 ) {
            val[idx] = x % 10;
            x /= 10;
            idx++;
        }
        
        int lo = 0, hi = val.length - 1;
        while( lo < hi ) {
            if( val[lo] != val[hi] ) return false;
            lo++;
            hi--;
        }
        return true;
    }
    
    public int getBase(int n) {
        int count = 0;
        while( n > 0 ) {
            count++;
            n /= 10;
        }
        return count;
    }
}
