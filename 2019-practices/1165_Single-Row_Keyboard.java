class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] keyIndics =  new int[26];
        int idx = 0;
        for( char ch : keyboard.toCharArray() ) {
            keyIndics[ ch - 'a' ] = idx++;
        }
        
        int curIdx = 0, sum = 0;
        for( char ch : word.toCharArray() ) {
            int pos = keyIndics[ ch - 'a' ];
            sum += Math.abs(pos - curIdx);
            curIdx = pos;
        }
        
        return sum;
    }
}
