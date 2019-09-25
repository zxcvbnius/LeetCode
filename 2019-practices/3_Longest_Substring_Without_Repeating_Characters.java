class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        int hi = 0, lo = 0, maxLen = 0;
        for(char ch : chars) {
            if( map.containsKey( ch ) ) {
                int len = hi - lo;
                if( len > maxLen ) maxLen = len;
                
                int idx = map.get( ch );
                if(lo < idx + 1) lo = idx + 1;
            }
            
            map.put( ch, hi );
            hi++;
        }
        
        int len = hi - lo;
        if( len > maxLen ) maxLen = len;
        
        return maxLen;
    }
}
