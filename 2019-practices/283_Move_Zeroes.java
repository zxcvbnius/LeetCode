class Solution {
    public void moveZeroes(int[] nums) {
        int countOfZero = 0;
        int curNotZeroIndex = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if( nums[i] == 0 ) {
                countOfZero++;
            } else {
                nums[curNotZeroIndex] = nums[i];
                curNotZeroIndex++;
            }
        }
        
        int curZeroIndex = nums.length - 1;
        for (int i = countOfZero ; i > 0 ; i-- ){
            nums[curZeroIndex] = 0;
            curZeroIndex--;
        }
    }
}
