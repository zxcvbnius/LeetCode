/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Example 1:
 * Input: k = 3, n = 7
 * 
 * Output:
 * 
 *  [[1,2,4]]
 * 
 * Result. "Your runtime beats 50.32% of java submissions."
 */
 public class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        getValideList(n, k, 0, new ArrayList<>());
        return res;   
    }
    
    public void getValideList(int target, int n, int curMaxNum, ArrayList<Integer> curList) {
        if( n == 1) {
            if(target >= 1 && target < 10 && curMaxNum < target ) {
                curList.add(target);
                ArrayList newList = new ArrayList<>();
                newList.addAll(curList);
                res.add(newList);
                curList.remove(curList.size() - 1);
            } 
        } else {
            for(int i = curMaxNum + 1 ; i < 10 ; i++) {
                curMaxNum = i;
                curList.add(i);
                getValideList( target - i, n - 1, curMaxNum, curList);                    
                curList.remove( curList.size() - 1);
            }
        }
    }
}
