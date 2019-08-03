class Solution {
    public int expressiveWords(String S, String[] words) {
        char[] sChar = S.toCharArray();
        
        int count = 0; // result
        for(int i = 0 ; i < words.length ; i++) {
            boolean isVaild = compareTwo(sChar, words[i].toCharArray());
            if(isVaild) count++;
        }
        
        return count;
    }
    
    public boolean compareTwo(char[] word1, char[] word2) {
        int pos1 = 0, pos2 = 0, len1 = word1.length, len2 = word2.length;
        while( pos1 < len1 && pos2 < len2 ) {
            char ch1 = word1[pos1];
            char ch2 = word2[pos2];
            if(ch1 != ch2) return false;
            
            int count1 = 0;
            while( pos1 < len1 && word1[pos1] == ch1 ) {
                count1++;
                pos1++;
            }
            
            int count2 = 0;
            while( pos2 < len2 && word2[pos2] == ch2 ) {
                count2++;
                pos2++;
            }
            if(count1 == count2) continue;
            else if(count1 < count2) return false;
            else if( count1 != count2 && count1 < 3 ) return false;
        }
        
        if(pos1 < len1) return false; // that means word1 still has remaining chars
        
        return true;
    }
}
