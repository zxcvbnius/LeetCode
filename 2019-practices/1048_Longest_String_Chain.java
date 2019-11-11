class Solution {
    public int longestStrChain(String[] words) {
        int len = words.length;

        Arrays.sort(words, (w1, w2) -> Integer.compare(w1.length(), w2.length()) );

        int max = 1;
        int[] dp = new int[ len ];
        for(int i = 0 ; i < len ; i++) dp[i] = 1;

        for(int i = 0 ; i < len ; i++) {
            for(int j = i+1 ; j < len ; j++) {
                if( isPredecessor( words[i], words[j] ) ) {
                    dp[j] = dp[i] + 1;
                    max = Math.max( max, dp[j] );
                }
            }
        }

        return max;
    }

    // return is s1 is the predecessor of s2
    public boolean isPredecessor(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if( len2 - len1 != 1 ) return false;

        int idx1 = 0, idx2 = 0;
        boolean canIgnore = true;
        while( idx1 < len1 && idx2 < len2 ) {
            if( s1.charAt(idx1) == s2.charAt(idx2) ) {
                idx1++;
                idx2++;
            } else if (canIgnore) {
                idx2++;
                canIgnore = false;
            } else {
                return false;
            }
        }
        return true;
    }
}


