/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * 
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 
 * Result. "Your runtime beats 25.31% of java submissions."
 */
public class NumArray {

    private int[] sums;
    public NumArray(int[] nums) {
        if(nums == null || nums.length > 0) {
            this.sums = new int[ nums.length ];
            this.sums[0] = nums[0];
            for(int i = 1 ; i < nums.length ; i++) {
                this.sums[i] = this.sums[i-1] + nums[i];
            }            
        }
    }

    public int sumRange(int i, int j) {
        if(this.sums == null || i < 0 || j >= this.sums.length) return -1;
        return this.sums[j] - ((i - 1 >= 0 ) ? this.sums[i-1] : 0 );
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
