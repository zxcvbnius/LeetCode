/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Result. "Your runtime beats 50.37% of java submissions."
 */
 public class Solution {
    public List<String> letterCombinations(String digits) {
        
        ArrayList<String> result = new ArrayList<>();
        
        if( digits == null || digits.indexOf("0") >= 0 || digits.indexOf("1") >= 0 || digits.length() == 0 ) return result;
        
        char[][] definitions = { 
            {},{}, // 0, 1
            {'a', 'b', 'c'}, // 2
            {'d', 'e', 'f'}, // 3
            {'g', 'h', 'i'}, // 4
            {'j', 'k', 'l'}, // 5
            {'m', 'n', 'o'}, // 6
            {'p', 'q', 'r', 's'}, // 7
            {'t', 'u', 'v'}, // 8
            {'w', 'x', 'y', 'z'} // 9
        };
        
        char[] chars = digits.toCharArray();
        int len = chars.length;
        boolean[][] used = new boolean[definitions.length][4];
        char[] currentChar = new char[len];
        
        dfs(chars, definitions, currentChar, 0, used, result);
        return result;
    }
    
    private void dfs(char[] chars, char[][] definitions, char[] currentChar, int curPosition, boolean[][] used, ArrayList<String> result) {
        if(chars.length == curPosition) {
            result.add( new String(currentChar) );
            return;
        }
        
        int index = chars[ curPosition ] - '0';
        for(int i = 0 ; i < definitions[ index ].length ; i++) {
            if( !used[curPosition][i] ) {
                currentChar[curPosition] = definitions[ index ][i];
                used[curPosition][i] = true;
                dfs(chars, definitions, currentChar, curPosition + 1, used, result);
                used[curPosition][i] = false;
            }
        }
    }
    
    
}
