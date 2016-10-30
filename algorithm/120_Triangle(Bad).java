/**
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * There are two solutions.
 */
 
// Sol1: Top to Bottom. Using recursive function to find minimum cost
// Bad Result. "Your runtime beats 16.67% of java submissions :("
// Bad Space complexity : more than O(N)
public class Solution {

    List<HashMap<Integer, Integer>> minCosts = new ArrayList<>();
    public int minimumTotal(List<List<Integer>> triangle) {
    	int len = triangle.size();
    	for(int i = 0 ; i < len ; i++) {
    		minCosts.add(new HashMap<Integer, Integer>());
    	}
      int res = getMinCost(triangle, triangle.get(0), 0, 0, triangle.size() );
      return res;
    }
    
    public int getMinCost(List<List<Integer>> triangle, 
        List<Integer> currentLine, 
        int currentPosition, 
        int currentLayer, 
        int totalLayers) {
    	
        if(totalLayers > currentLayer + 1) { // have nextLine
            
            int nextLayer = currentLayer + 1;
            int leftCost, rightCost;
            
            Integer left  = minCosts.get(nextLayer).get(currentPosition);
            Integer right = minCosts.get(nextLayer).get(currentPosition+1);
            
            if(left != null) {
            	leftCost = left.intValue();
            } else {
            	leftCost  = getMinCost(triangle, triangle.get(nextLayer), currentPosition, nextLayer, totalLayers);
            	minCosts.get(nextLayer).put(currentPosition, leftCost);
            }
            
            if(right != null) {
            	rightCost = right;
            } else {
            	rightCost = getMinCost(triangle, triangle.get(nextLayer), currentPosition + 1, nextLayer, totalLayers);
            	minCosts.get(nextLayer).put(currentPosition + 1, rightCost);
            }
            int min = Math.min( leftCost, rightCost);
            return currentLine.get(currentPosition) + min; 
                
        } else {
            return currentLine.get(currentPosition);
        }
    }
}


// Sol2: Bttom to Up. Using dynamic programming to find minimum cost
// Better Result. "Your runtime beats 47.62% of java submissions."
// Better Space complexity : O(N) and time complexity: O(N)
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int len        = triangle.size();
        int[] minCosts = new int[len];
        //initial by last row 
        int last = triangle.get(len-1).size();
        for(int i = 0; i < last ; i++) {
            minCosts[i] = triangle.get(len-1).get(i);
        }
        
        // start from last 2 row
        // iterate from last second row
        for(int i = len - 2 ; i >= 0; i--) {
            for(int j = 0 ; j < triangle.get(i).size() ; j++) {
                minCosts[j] = Math.min(minCosts[j], minCosts[j+1]) + triangle.get(i).get(j);
            }
        }
        return minCosts[0];
    }

}
