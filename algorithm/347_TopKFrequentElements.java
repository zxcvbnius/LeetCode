/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * Result. "Your runtime beats  99.63% of java submissions. O.O"
 */
 // Using bucket sorting
 public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        if(len == 0) return res;
        
        
        Arrays.sort(nums);
        
        int max = nums[len - 1];
        
        HashMap<Integer, Integer> counts = new HashMap<>();
        
        {
            int current = nums[0];
            int count   = 1;
            for(int i = 1 ; i < len ; i++) {
                if(current == nums[i]) count++;
                else {
                    counts.put(current, count);
                    current = nums[i];
                    count   = 1;
                }
            }
            counts.put(current, count);
        }
        
        List<Integer>[] bucket = new List[nums.length + 1];
        
        for(int key : counts.keySet()) {
            int count = counts.get(key);
            if( bucket[count] == null ) bucket[count] = new ArrayList<>();
            bucket[count].add(key);
        }
        
        int count = 0;
        for(int i = nums.length ; i >=0 && count < k ; i--) {
            if(bucket[i] != null) {
                res.addAll(bucket[i]);
                count += bucket[i].size();                
            }
        }
        
        return res;
    }
    
}
