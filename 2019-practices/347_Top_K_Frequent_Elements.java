class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        if(k == 0) return new ArrayList<>();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            Integer count = map.get(n);
            if( count == null) {
                map.put(n, 1);
            } else{
                map.put(n, count + 1);
            }
        }
        
        List<Integer>[] freq = new ArrayList[ nums.length + 1 ];
        for(int i = 0 ; i < nums.length + 1 ; i++) freq[i] = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++) {
            if( !map.containsKey(nums[i]) ) continue;
            int count = map.get(nums[i]);
            freq[ count ].add( nums[i] );
            map.remove( nums[i] );
        }
        
        int remaining = k;
        List<Integer> ans = new ArrayList<>();

        for(int i = nums.length ; i >= 0 ; i--) {
            int size = freq[i].size();
            for(int j = size - 1; j >= 0 ; j--) {
                ans.add( freq[i].get( j ) );
                remaining--;
                if(remaining == 0 ) break;
            }
            if(remaining == 0 ) break;
        }
        return ans;
    }
}
