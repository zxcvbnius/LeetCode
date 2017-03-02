/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 */
 
 // Result. "Your runtime beats 55.71% of java submissions."
 // Time complexity is : O(N)
 public class Solution {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }
    
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
 
 
 // Result. "Your runtime beats 78.68% of java submissions."
 // Time complexity is : O(N^2)
 public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        boolean hasPositive = false;
        boolean hasOne = false;
        int currentMinPos = Integer.MIN_VALUE;
        for(int n : nums) {
            if( n > 0) {
                hasPositive = true;
                if(currentMinPos < n) currentMinPos = n;
                if(n == 1) hasOne = true;
            }
        }
        if(!hasPositive) return 1;
        if(!hasOne) return 1;
        for(int i = 2 ; i < currentMinPos; i++) {
            boolean exist = false;
            for(int n : nums) {
                if(i == n) {
                    exist = true;
                    break;
                }
            }
            if(!exist) return i;
        }
        return currentMinPos + 1;
    }
}
