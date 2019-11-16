// Time complexity: O(N^2)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[ len + 1 ];
        
        for(int i = 1 ; i <= len ; i++) {
            preSum[ i ] = preSum[ i - 1 ] + nums[i-1];
        }
        
        int count = 0;
        for(int i = 0 ; i <= len ; i++) {
            for(int j = i + 1 ; j <= len ; j++ ) {
                if( preSum[j] - preSum[i] == k ) count++;
            }
        }
        return count;
    }
}

// Time complexity: O(N)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length, count = 0, sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i  = 0 ; i < len ; i++) {
            sum += nums[i];

            if( map.containsKey( sum - k ) ) {
                count += map.get( sum - k );
            }

            map.put( sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
