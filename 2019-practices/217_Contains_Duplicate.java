class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null) return false;
        
        Set<Integer> result = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++) {
            result.add(nums[i]);
        }
        
        return result.size() != nums.length;
    }
}
