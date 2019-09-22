class Solution {
    public long gcd(long a, long b) {
        if(a == 0) return b;
        return gcd( b % a, a);
    }
    public long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
    public int count(long a, long b, long c, long num) {
        return (int) ( (num / a) + (num / b) + (num / c) 
            - (num / lcm(a, b) )
            - (num / lcm(b, c) )
            - (num / lcm(a, c) )
            + (num / lcm(a, lcm(b, c)) ));
    }
    public int nthUglyNumber(int n, int a, int b, int c) {
        long left = 0, right = Integer.MAX_VALUE, mid = -1;
        
        while( left < right ) {
            mid = left + (right - left) / 2;
            int num = count(a, b, c, mid);
            if( num >= n ) right = mid;
            else if( num < n ) left = mid + 1;
        }
        
        return (int)right;
    }
}
