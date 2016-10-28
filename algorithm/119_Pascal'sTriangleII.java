/**
 * Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * Result. "Your runtime beats 60.67% of java submissions :("
 */
 public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
    	if(rowIndex == 0) {
    		result.add(1);
    	} else if(rowIndex == 1) {
    		result.add(1);
    		result.add(1);
    	} else {
    		result.add(1);
    		result.add(1);
    		for(int i = 1 ; i < rowIndex; i++) {
    			result = getNextList(result);
		    }
    	}
    	return result;
    }
    
    public List<Integer> getNextList(List<Integer> curList) {
		int len = curList.size();
		List<Integer> nextList = new ArrayList<Integer>();
		int val = curList.get(0);
		nextList.add(1);
		for(int i = 1; i < len; i++) {
		   int cur = curList.get(i);
		   nextList.add(cur + val);
		   val = cur;
	    }
		nextList.add(1);
		return nextList;
	}
}
