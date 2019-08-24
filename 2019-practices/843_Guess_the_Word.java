/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public int findMatch(String word1, String word2) {
        int match = 0, len = word1.length();
        for(int i = 0 ; i < len ; i++) {
            if( word1.charAt(i) == word2.charAt(i) ) match++;
        }
        return match;
    }
    
    public String[] shrinkWordList(String[] wordlist, String target, int match) {
        List<String> list = new ArrayList<>();
        for(String word: wordlist) {
            if( findMatch(target, word) == match && !word.equals(target) ) {
                list.add( word );
            }
        }
        return list.toArray( new String[ list.size() ] );
    }

    public void findSecretWord(String[] wordlist, Master master) {
        int count = 10;
       
        while( count > 0 ) {
            Random r = new Random();
            int random = r.nextInt(wordlist.length);

            String target = wordlist[random];
            int guess = master.guess( target );
            if( guess == 6 ) return;
            wordlist = shrinkWordList( wordlist, target, guess);
            count--;
        }
    }
}
