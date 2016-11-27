/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If nums = [1,2,3], a solution is:
 * 
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 
 * Result. "Your runtime beats 28.82% of java submissions."
 */
 public class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        
        if(nums == null) return res;
        
        res.add(new ArrayList<>()); // empty array
        
        quicksort(nums, 0, nums.length - 1);
        
        for(int i = 1 ; i < nums.length + 1 ; i++) {
            getSubCombinations(i, -1, nums, new ArrayList<>());
        }
        
        return res;
        
    }
    
    public void getSubCombinations(int n, int curMaxIndex, int[] nums, ArrayList<Integer> curList) {
        
        if(n == 1) {
            for(int i = curMaxIndex + 1 ; i < nums.length ; i++) {
              ArrayList<Integer> newList = new ArrayList<>();
                newList.addAll(curList);
                newList.add( nums[i] );
                res.add(newList);  
            }
        } else {
            for(int i = curMaxIndex + 1 ; i < nums.length ; i++) {
                curList.add( nums[i] );
                getSubCombinations(n - 1, i, nums, curList);
                curList.remove( curList.size() - 1);
            }
        }
        
    }
    
    public void quicksort(int[] nums, int left, int right) {
        int i = left, j = right, pivot = nums[ (left + right) / 2 ];
        while(i <= j) {
            while(pivot > nums[i]) i++;
            while(pivot < nums[j]) j--;
            if(i <= j) {
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
