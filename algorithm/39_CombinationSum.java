/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7, 
 * A solution set is: 
 * [
 *   [7],
 *   [2, 2, 3]
 * ]
 * 
 * Result. "Your runtime beats 30.33% of java submissions."
 */

// Or you can remove quicksort, it would accept!!
 public class Solution {
    
    private List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if(candidates == null) return res;
        quicksort(candidates, 0, candidates.length - 1);
        getCombinations(candidates, target, 0, new ArrayList<>(), 0);
        
        return res;
    }
    
    public void getCombinations(int[] nums, int target, int curSum, List<Integer> curList, int start) {
        
        if(curSum == target) {
            ArrayList<Integer> newList = new ArrayList<>(curList);
            res.add(newList);
        } else if( curSum < target) {
            for(int i = start ; i < nums.length ; i++) {
                curList.add(nums[i]);
                getCombinations(nums, target, curSum + nums[i], curList, i);
                curList.remove( curList.size() - 1);
            }
        }
    }
    
    public void quicksort(int[] nums, int left, int right) {
        int i = left, j = right, pivot = nums[(left + right) / 2];
        while( i<= j ) {
            while(pivot > nums[i] ) i++;
            while(pivot < nums[j] ) j--;
            if( i <= j ) {
                int temp = nums[i];
                nums[i]  = nums[j];
                nums[j]  = temp;
                i++;
                j--;
            }
        }
        if(left < j) quicksort(nums, left, j);
        if(i < right) quicksort(nums, i, right);
    }
}
