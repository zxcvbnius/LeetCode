class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int result = Integer.MIN_VALUE;

        if(len == 1) return nums[0]; // only one house case
        if(len == 2) return Math.max(nums[0], nums[1]); // // two houses case


        int[] maxProfit = new int[len];
        maxProfit[0] = nums[0];
        maxProfit[1] = Math.max( nums[0], nums[1]);

        for(int i = 2 ; i < len ; i++) {
            maxProfit[i] = Math.max( maxProfit[i-2] + nums[i], maxProfit[i-1]);
            if(result < maxProfit[i]) result = maxProfit[i];
        }

        return result;
    }
}
