class Solution {
    public String nextClosestTime(String time) {
        int[] nums = new int[ 4 ];
        nums[0] = time.charAt(0) - '0';
        nums[1] = time.charAt(1) - '0';
        nums[2] = time.charAt(3) - '0';
        nums[3] = time.charAt(4) - '0';
        
        if( nums[0] == nums[1] && nums[1] == nums[2] && nums[2] == nums[3] ) return time;
        
        int source = toTime( nums[0] * 10 + nums[1], nums[2] * 10 + nums[3]);
        dfs(nums, 0, new int[4], source);
        return String.format("%02d:%02d", H, M );
    }
    
    private int res = Integer.MAX_VALUE, H = 0, M = 0;
    
    public void dfs(int[] nums, int curLen, int[] time, int source) {
        if( curLen == 4) {
            int hour = time[0] * 10 + time[1];
            int min = time[2] * 10 + time[3];
            if( hour > 23 || min > 59 ) return;

            int secs = toTime( hour, min );
            int diff = secs - source;
            if(diff == 0) return;
            if( diff < 0 ) diff += 1440;
            
            if( diff < res ) {
                res = diff;
                H = hour;
                M = min;
            }
            return;
        }
        
        for(int i = 0 ; i < 4 ; i++) {
            time[curLen] = nums[i];
            dfs( nums, curLen + 1, time, source );
        }
        
    }
    
    public int toTime(int hour, int min) {
        return hour * 60 + min;
    }
}
