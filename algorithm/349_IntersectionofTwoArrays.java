/**
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 * 
 * Result. "Your runtime beats  77.77% of java submissions."
 * Sol. Using binary search O(N)
 */
 public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums1.length ; i++) {
            map.put(nums1[i], 1);
        }
        ArrayList<Integer> lists = new ArrayList<>();
        for(int i = 0 ; i < nums2.length ; i++) {
            if(map.remove(nums2[i]) != null ) {
                lists.add(nums2[i]);
            }
        }
        
        int count = 0;
        int[] res = new int[lists.size()];
        for(Integer i: lists ) {
            res[count] = i;
            count++;
        }
        return res;
    }
}
