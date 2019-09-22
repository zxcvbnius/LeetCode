class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] index = new int[ primes.length ];
        int[] ugly = new int[ n ];
        ugly[0] = 1;
        
        for(int i = 1 ; i < n ; i++) {
            int min = ugly[ index[0] ] * primes[0];

            for(int j = 1 ; j < primes.length ; j++) {
                int val = ugly[ index[j] ] * primes[j];
                if(min > val) min = val;
            }
            
            ugly[i] = min;
            
            for(int j = 0 ; j < primes.length ; j++) {
                int val = ugly[ index[j] ] * primes[j];
                if( min == val ) index[j]++;
            }
        }
        
        return ugly[n-1];
    }
}
