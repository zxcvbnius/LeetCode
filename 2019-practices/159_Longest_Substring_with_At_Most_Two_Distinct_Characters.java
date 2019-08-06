class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int lo = 0, hi = 0, len = s.length(), maxSize = 0;

        char[] sChar = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>(); // value, index
        
        while(hi < len) {
            if( map.size() <= 2) {
                map.put( sChar[hi], hi );
                hi++;
            }
            
            if( map.size() > 2) {
                int left_most_idx = sChar.length;
                Character left_most_val = null;
                for( Character ch : map.keySet() ) {
                    int index = map.get( ch );
                    if(index < left_most_idx) {
                        left_most_idx = index;
                        left_most_val = ch;
                    }
                }
                map.remove( left_most_val );
                lo = left_most_idx + 1;
            }
            
            int size = hi - lo;
            if(size > maxSize) maxSize = size;
        }
            
        return maxSize;
    }
}
