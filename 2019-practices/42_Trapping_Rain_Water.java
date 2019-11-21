class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[ len ];
        int[] right = new int[ len ];
        
        // arr:   [0,1,0,2,1,0,1,3,2,1,2,1]
        // left:  [0,1,1,2,2,2,2,3,3,3,3,3]
        // right: [0,3,3,3,3,3,3,3,2,2,2,1]
        // vol:   [0,0,1,0,1,2,1,0,0,1,0,0]
        
        int highest = 0;
        for(int i = 0 ; i < len ; i++) {
            highest = Math.max( highest, height[i]);
            left[i] = highest;
        }
        
        highest = 0;
        for(int i = len - 1 ; i >= 0 ; i--) {
            highest = Math.max( highest, height[i]);
            right[i] = highest;
        }
        
        int ans = 0;
        for(int i = 0 ; i < len ; i++) {
            int minHeight = Math.min( left[i], right[i] );
            if( minHeight > height[i] ) {
                ans += minHeight - height[i];
            }
        }
        
        return ans;
    }
}
