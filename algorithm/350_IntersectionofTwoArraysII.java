/**
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Result. "Your runtime beats 39.10% of java submissions."
 * Runtime: 7 ms
 */
 
 public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums1) {
            Integer val = map.get(i);
            if(val == null) map.put(i, 1);
            else map.put(i, val + 1);
        }
        
        ArrayList<Integer> lists = new ArrayList<>();
        for(int i : nums2) {
            Integer val = map.get(i);
            if(val != null && val != 0) {
                lists.add(i);
                map.put(i, val-1);                
            }
        }
        
        
        int[] res = new int[lists.size()];
        int index = 0;
        for(int i : lists) {
            res[index] = i;
            index++;            
        }
        return res;
    }
    
}
