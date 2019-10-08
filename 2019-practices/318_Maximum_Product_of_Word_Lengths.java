class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] values = new int[ len ];
        
        int idx = 0;
        for(String word : words) {
           for( char ch : word.toCharArray() ) {
              values[ idx ] |= 1 << ch - 'a';
           }
           idx++;
        }

        int max = 0;
        for(int i = 0 ; i < len ; i++) {
           for(int j = i + 1 ; j < len ; j++) {
             if( (values[i] & values[j] ) != 0 ) continue;
             int res = words[i].length() * words[j].length();
             max = Math.max( res, max);
           }
        }
        return max;        
    }
}
