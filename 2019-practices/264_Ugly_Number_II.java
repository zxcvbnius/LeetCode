class Solution {
    public int nthUglyNumber(int n) {
        int curVal = 1;
        int[] index = {0, 0, 0};

        int[] ugly = new int[ n ];
        ugly[0] = 1;
        
        for(int i = 1 ; i < n ; i++) {
            ugly[i] = Math.min( Math.min( ugly[index[0]]*2, ugly[index[1]]*3 ), ugly[index[2]]*5);

            if( ugly[i] == ugly[index[0]]*2 ) index[0]++;
            if( ugly[i] == ugly[index[1]]*3 ) index[1]++;
            if( ugly[i] == ugly[index[2]]*5 ) index[2]++;
        }
        
        return ugly[ n - 1 ];
    }
}
