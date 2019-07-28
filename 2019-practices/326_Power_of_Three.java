class Solution {
    public boolean isPowerOfThree(int n) {
        int [] array = new int[20];
        int curValue = array[0] = 1;
        
        for(int i = 1 ; i < array.length ; i++) {
            curValue *= 3;
            array[i] = curValue;
        }
        
        for(int i = 0 ; i < array.length ; i++) {
            if( array[i] == n ) return true;
        }
        
        return false;
    }
}
