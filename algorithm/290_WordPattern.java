/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *   Examples:
 *     pattern = "abba", str = "dog cat cat dog" should return true.
 *     pattern = "abba", str = "dog cat cat fish" should return false.
 *     pattern = "aaaa", str = "dog cat cat dog" should return false.
 *     pattern = "abba", str = "dog dog dog dog" should return false.
 */
 
 // Sol1. Using array to record
 // Result. "Your runtime beats 19.67% of java submissions :("
 public class Solution {
    public boolean wordPattern(String pattern, String str) {

        if(pattern.length() == 0 ) return false;
        
        String[] map = new String[256];
        String[] patterns = pattern.split("");
        String[] tokens   = str.split(" ");
        
        if(patterns.length != tokens.length) return false;
        
        for(int i = 0 ; i < tokens.length ; i++) {
            int index = Character.getNumericValue(patterns[i].charAt(0));
            if(map[ index ] == null) {
                for(int j = 0 ; j < map.length ; j++) {
                    if(map[j] != null && map[j].equals(tokens[i]) ) return false;
                }
                map[ index ] = tokens[i];
            } else {
                if( !map[index].equals(tokens[i]) ) return false;
            }
        }
        return true;
    }
}

// Sol2. Using HashMap
