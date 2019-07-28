class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // target-val, the index of value
        
        for(int i = 0 ; i < nums.length ; i++) {
            if( map.containsKey(nums[i]) ) {
                return new int[]{ map.get(nums[i]), i };
            }
            map.put(target - nums[i], i);
        }
        
        return null;
    }
}
