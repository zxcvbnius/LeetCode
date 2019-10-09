class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for(int n : nums) {
            if( n == 0 ) count0++;
            else if( n == 1 ) count1++;
            else if( n == 2 ) count2++;
        }
        
        int idx = 0;
        while( count0 > 0 ) {
            nums[ idx++ ] = 0;
            count0--;
        }
        
        while( count1 > 0 ) {
            nums[ idx++ ] = 1;
            count1--;
        }
        while( count2 > 0 ) {
            nums[ idx++ ] = 2;
            count2--;
        }
    }
}
