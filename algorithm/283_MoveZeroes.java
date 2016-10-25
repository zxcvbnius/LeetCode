public class Solution {
  public void moveZeroes(int[] nums) {
    int len = nums.length;
    int position = 0;
    for(int i = 0 ; i < len; i++) {
      if(nums[i] != 0 ) {
        nums[position] = nums[i];
        position++;
      }
    }

    while(position < len) {
      nums[position] = 0;
      position++;
    }
  }
}
