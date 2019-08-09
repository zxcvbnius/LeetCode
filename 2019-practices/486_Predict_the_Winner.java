class Solution {
    
    HashMap<Integer, Integer> cache = new HashMap<>();
    
    public boolean PredictTheWinner(int[] nums) {
        return getMaxScore(nums, 0, nums.length - 1) >= 0;
    }
    
    public int getMaxScore(int[] nums, int start, int end) {
        if( start == end ) return nums[start];
        
        int key = start * 100 + end;
        if( cache.containsKey( key ) ) return cache.get(key);
        
        int val1 = getMaxScore( nums, start + 1, end);
        int val2 = getMaxScore( nums, start, end - 1);
        
        cache.put(  (start + 1) * 100 + end, val1  );
        cache.put(  start * 100 + (end - 1), val2  );
        
        int max = Math.max( nums[start] - val1, nums[end] - val2);
        
        cache.put( key , max);
        
        return max;
    }
}
