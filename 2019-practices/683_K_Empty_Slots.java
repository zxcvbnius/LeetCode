class Solution {
    public int kEmptySlots(int[] bulbs, int K) {
        int[] days = new int[ bulbs.length + 1 ];
        for(int i = 0 ; i < bulbs.length ; i++) {
            days[ bulbs[i] ] = i + 1;
        }
        
        int left = 1, right = left + K + 1, res = Integer.MAX_VALUE;

        for(int i = 1 ; i < days.length && right < days.length ; i++) {
            if( days[ left ] > days[i] || days[ right ] >= days[i] ) {
                if( i == right ) res = Math.min(res, Math.max(days[left], days[right]) );
                left = i;
                right = left + K + 1;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
        
    }
}
