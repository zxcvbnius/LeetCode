/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * Result. "Your runtime beats 55.64% of java submissions."
 */
 public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null) return results;
        if(nums.length < 3) return results;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++ ) {
            if( nums[i]*3 > 0 ) break;
            int sum = 0 - nums[i];
            int start = i+1;
            int end   = nums.length - 1;
            while(start < end && start < nums.length ) {
                if( nums[start] + nums[end] > sum ) end--;
                else if( nums[start] + nums[end] < sum ) start++;
                else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    results.add(list);
                    int val = nums[start];
                    while(start < nums.length && val == nums[start] ) start++;
                    val = nums[end];
                    while(end >= 0 && val == nums[end]) end--;
                }
            }
            int v = nums[i];
            int add = i;
            if(add < nums.length) while( add < nums.length &&  v == nums[add] ) add++;
            if(add != i) i = (add - 1);
            
        } 
        return results;
    }
    
}
