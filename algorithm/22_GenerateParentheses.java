/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * Result. "Your runtime beats 92.13% of java submissions."
 */
 public class Solution {
    
    private ArrayList<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        char[] chars = new char[n*2];
        dfs(chars, 0, n, n);
        return result;
    }
    public void dfs(char[] curChars, int curPosition, int left, int right) {
        if(left == 0 && right == 0) {
            result.add( new String(curChars) );
        }
        if(left > right) {
            return;
        }
        
        if(left > 0) {
            curChars[curPosition] = '(';
            dfs(curChars, curPosition + 1, left - 1, right);
        } 
        if(right > 0) {
            curChars[curPosition] = ')';
            dfs(curChars, curPosition + 1, left, right - 1);
        }
    }
    
}
