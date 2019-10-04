class Solution {
    public boolean isStrobogrammatic(String num) {
        int[] storbogs = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        
        char[] chars = num.toCharArray();
        int lo = 0, hi = chars.length - 1;
        
        if( ( lo + hi ) % 2 == 0 ) {
            int mid = num.charAt( ( lo + hi ) / 2 ) - '0';
            if( (mid != 0 && mid != 1 && mid != 8) ) {
                return false;
            }
        }   
        
        while( lo < hi ) {
            if( storbogs[ num.charAt(lo) - '0' ] != num.charAt(hi) - '0' ) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
