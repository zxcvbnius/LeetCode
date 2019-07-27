/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * Example 1:
 *   Input: ["Hello", "Alaska", "Dad", "Peace"]
 *   Output: ["Alaska", "Dad"]
 *  
 * Result. "Your runtime beats 82.65% of java submissions."
 */
 public class Solution {
    public String[] findWords(String[] words) {
        if(words == null) return new String[0];
        ArrayList<String> result = new ArrayList<>();
        for(String word : words) {
            char[] chars = word.toLowerCase().toCharArray();
            char[] row = getRow(chars[0]);
            
            boolean isSameRow = true;
            for(char ch : chars) {
                boolean contains = false;
                for(char r : row) {
                    if(r == ch) contains = true;
                }
                if(!contains) {
                    isSameRow = false;
                    break;
                }
            }
            if(isSameRow) result.add(word);
        }
        
        String[] aws = new String[ result.size() ];
        int index = 0;
        for(String r : result) {
            aws[index++] = r;
        }
        return aws;
    }
    public char[] getRow(char firstChar) {
        char[][] rows = {
            {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
            {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
            {'z', 'x', 'c', 'v', 'b', 'n', 'm'}
            };
        for(int i = 0 ; i < rows.length ; i++) {
            for(char ch : rows[i]) {
                if(ch == firstChar) return rows[i];
            }
        }    
        return null;
    }
}
