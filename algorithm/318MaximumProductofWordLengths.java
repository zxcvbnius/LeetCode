/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 * 
 * Example 1:
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn".
 * 
 * Example 2:
 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * Return 4
 * The two words can be "ab", "cd".
 */
 
// Result. "Your runtime beats 56.63%% of java submissions."
//  Sol. time complexity is O(N^2) and using Integer 32 bit as mask
public class Solution {
    public int maxProduct(String[] words) {
        if(words == null) return 0;
        int maxProduct = 0;
        int[] masks = new int[ words.length ];
        for(int i = 0 ; i < words.length ; i++) {
            char[] array = words[i].toCharArray();
            for(char ch : array) {
                masks[i] |= 1 << (ch - 'a');
            }
        }
        for(int i = 0 ; i < masks.length ; i++) {
            for(int j = i + 1 ; j < masks.length ; j++) {
                if((masks[i] & masks[j]) == 0) {
                    int val = words[i].length() * words[j].length();
                    if(maxProduct < val) maxProduct = val;
                }
            }
        }
        return maxProduct;
    }
}
 
 
// Result. "Your runtime beats 25% of java submissions. : ("
//  Sol. time complexity is O(N^3)
public class Solution {
    public int maxProduct(String[] words) {
        if(words == null) return 0;
        boolean[][] records = new boolean[words.length][26];
        for(int i = 0 ; i < words.length ; i++) {
            String word = words[i];
            char[] charArray = word.toCharArray();
            for(int j = 0 ; j < charArray.length ; j++) {
                char ch = charArray[j];
                records[i][ch - 97] = true;
            }
        }
        int maxProduct = 0;
        for(int i = 0 ; i < words.length ; i++) {
            for(int j = i + 1 ; j < words.length ; j++) {
                boolean[] iRecords = records[i];
                boolean[] jRecords = records[j];
                boolean sameCh = false;
                for(int k = 0 ; k < iRecords.length ; k++) {
                    if( iRecords[k] && (iRecords[k] == jRecords[k]) ) {
                        sameCh = true;
                        break;
                    }
                }
                if(!sameCh) {
                    int val = words[i].length() * words[j].length();
                    if(maxProduct < val) maxProduct = val;
                }
            }
        }
        return maxProduct;
    }
}
