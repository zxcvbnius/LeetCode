/**
 * Given an array S of n integers, are there elements a, b, c, and d in S 
 * such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note: The solution set must not contain duplicate quadruplets.
 * Result. "Your runtime beats 93.57% of java submissions"
 * Time complexity : O(N^3)
 */
 
 public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len < 4) return res;
                
        Arrays.sort(nums);
        
        int max = nums[len - 1];
        if(4*nums[0] > target || 4 * max < target ) return res;
        
        for(int i = 0 ; i < len ; i++) {
            int val = nums[i];
            if(i > 0 && val == nums[i-1]) continue; // avoid duplicate
            else if(val + 3 * max < target) continue; // val is too small
            else if(4 * val > target) continue; // val is too large
            else if(4 * val == target) { // val is the boundary
                if(i + 3 < len && nums[i + 3] == val) {
                    res.add( Arrays.asList(val, val, val, val) );
                    break;
                }
            }
            threeSumForFourSum(nums, target - val, i + 1, len - 1, res, val);
        }
        return res;
    }
    
    public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> res, int val) {
        if(low + 1 >= high) return;
        int max = nums[high];
        if(3 * nums[low] > target || 3 * max < target) return;
        
        for(int i = low ; i < high - 1; i++) {
            int val2 = nums[i];
            if(i > low && val2 == nums[i - 1] ) continue; // avoid duplicate
            else if(val2 + 2 * max < target) continue;// val2 is too small
            else if(3 * val2 > target) continue; // val2 is too large
            else if(3 * val2 == target) {
                if(i + 2 < high && nums[i + 2] == val2) {
                    res.add( Arrays.asList(val, val2, val2, val2) );
                    break;
                }
            }
            twoSumForFourSum(nums, target - val2, i + 1, high, res, val, val2);
        }
    }
    
    public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> res, int val, int val2) {
        if(low >= high) return;
        if(2 * nums[low] > target || 2 * nums[high] < target) return;
        
        int i = low, j = high;
        while(i < j) {
            int sum = nums[i] + nums[j];
            if(sum == target) {
                res.add( Arrays.asList(nums[i], nums[j], val, val2) );
                
                int x = nums[i];
                while(i <= high && nums[i] == x) i++; // avoid duplicate
                x = nums[j];
                while( i < j && nums[j] == x) j--; // avoid duplicate
            } else if(sum < target) {
                i++;
            } else if(sum > target) {
                j--;
            }
        }
    } 
    
    
}
 
