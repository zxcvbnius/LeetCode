class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums == null || nums.length < 3 ) return res;

        Arrays.sort( nums );
        for(int i = 0 ; i < nums.length ; i++) {
            if( nums[i] * 3 > 0 ) break;
            int target = 0 - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            
            while( start < end ) {
                int sum = nums[start] + nums[end];
                if( sum > target ) end--;
                else if( sum < target ) start++;
                else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add( nums[i] );
                    list.add( nums[start] );
                    list.add( nums[end] );
                    res.add(list);
                    
                    int val = nums[start];
                    while( start < nums.length && val == nums[start] ) start++;
                    val = nums[end];
                    while( end >= 0 && val == nums[end] ) end--;
                }
            }
            int val = nums[i], idx = i + 1;
            while( idx < nums.length && val == nums[ idx ]) idx++;
            i = idx - 1;
        }
        
        return res;
    }
}
