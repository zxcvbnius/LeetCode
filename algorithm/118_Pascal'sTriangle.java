/**
 * Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * Result. "Your runtime beats 30.67% of java submissions :("
 */
 public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows == 0) return result;
        getTriangle(result, numRows);
        return result;
    }
    
    public List<Integer> getTriangle(List<List<Integer>> result, int num) {
		List<Integer> res = new ArrayList<Integer>();
		if(num == 1) {
			res.add(1);
		} else {
			List<Integer> lastList = getTriangle(result, num - 1);
			res.add(1);
			int len = lastList.size();
			int val = lastList.get(0);
			for(int i = 1; i < len; i++) {
				int cur = lastList.get(i);
				res.add( val + cur );
				val = cur;
			}
			res.add(1);
		}
		result.add(res);
		return res;
	}
}
