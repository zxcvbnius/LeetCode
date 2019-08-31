class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int idx = 0;
        int min = words.length + 1, last1 = -1, last2 = -1;

        for(String word: words) {
            if( word.equals(word1) ) last1 = idx;
            if( word.equals(word2) ) last2 = idx;
            idx++;
            
            if(last1 >= 0 && last2 >= 0) {
                int res = last1 > last2 ? last1 - last2 : last2 - last1;
                min = Math.min(min, res );
            }
        }

        return min;
    }
}
