class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int len = nums.length;
        if( len == 0 ) return 0;

        int[] preSum = new int[ len + 1 ];

        for(int i = 1 ; i <= len ; i++) {
          preSum[i] = preSum[ i-1 ] + nums[ i-1 ];
        }

        // time complexity: O(N^2)
        int maxLen = 0;
        for(int i = 0 ; i <= len ; i++) {
            for(int j = i ; j <= len ; j++) {
                if( preSum[j] - preSum[i] <= k ) {
                    maxLen = Math.max( maxLen, j - i );
                }
            }
        }
        return maxLen;
    }
}

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int len = nums.length, sum = 0, idx = 0, maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // sum, right index

        for( int n : nums ) {
            sum += n;
            Integer right = map.get( sum - k  );

            if( sum == k ) {
                maxLen = Math.max( maxLen, idx + 1 );
            }
            else if( right != null ) {
                maxLen = Math.max( maxLen, idx - right );
            }

            if( !map.containsKey(sum) ) {
                map.put( sum, idx );
            }
            idx++;
        }
        return maxLen;

    }
}
