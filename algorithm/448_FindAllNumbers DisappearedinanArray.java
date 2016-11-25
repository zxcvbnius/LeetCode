/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * Result. "Your runtime beats 13.72% of java submissions."
 */
 
 // Space compleixty: O(1)
 // Result. "Your runtime beats 13.72% of java submissions."
 public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        
        quicksort(nums, 0, nums.length - 1);
        
        int curIndex = 0;
        
        for(int i = 0 ; i < nums.length ; i++) {
            if( curIndex < nums[i] ) {
                while(nums[i] - curIndex > 1) {
                    curIndex++;
                    res.add(curIndex);
                } 
                curIndex = nums[i];
            }
        }
        
        while(nums.length - curIndex > 0) {
            curIndex++;
            res.add(curIndex);
        }
        
        return res;
    }
    
    public void quicksort(int[] nums, int left, int right) {
        int i = left, j = right , pivot = nums[ (left + right) / 2 ];
        while(i <= j) {
            while( pivot > nums[i] ) i++;
            while( pivot < nums[j] ) j--;
            
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
 
 
 // Space compleixty: O(N)
 // Result. "Your runtime beats 13.72% of java submissions."
 public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        ArrayList<Integer> res = new ArrayList<>();
        
        if(nums == null) return res;
        
        int[] counts = new int[ nums.length + 1 ];
        for(int n : nums) {
            counts[n]++;
        }
        
        for(int i = 1 ; i < counts.length ; i++) {
            if(counts[i] == 0) res.add(i);    
        }
        
        return res;
    }
}
