/**
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Result. Your runtime beats 79.14% of java submissions. :)
 */

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1.length == 0 || nums2.length == 0) return new int[0];
        
        quicksort(nums1, 0, nums1.length - 1);
        quicksort(nums2, 0, nums2.length - 1);
        
        ArrayList<Integer> list = (nums1.length > nums2.length) ? getIntersects(nums1, nums2) : getIntersects(nums2, nums1);
        int[] res = new int[list.size()];
        int index = 0;
        for(int i : list) {
            res[index] = i;
            index++;
        }
        return res;
    }
    
    public ArrayList<Integer> getIntersects(int[] longNums, int[] shortNums) {
        int index1 = 0;
        int index2 = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(index1 < longNums.length) {
            if(index2 >= shortNums.length) {
                break;
            } else {
                if(longNums[index1] > shortNums[index2]) {
                    index2++;
                } else if(longNums[index1] < shortNums[index2]) {
                    index1++;
                } else { // longNums[index1] == shortNums[index2] 
                    list.add(longNums[index1]);
                    index1++;
                    index2++;
                }
            }
        }
        return list;        
    }
    
    public void quicksort(int[] nums, int left, int right) {
        if(left >= right) return ;
        int i = left, j = right, pivot = nums[(left+right) / 2];
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
        if(left < j ) quicksort(nums, left, j);
        if(i < right) quicksort(nums, i, right);
    }
    
}
