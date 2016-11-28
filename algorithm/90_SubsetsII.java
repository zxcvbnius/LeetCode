/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If nums = [1,2,2], a solution is:
 * 
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 
 * Result. "Your runtime beats 68.91% of java submissions."
 */
public class Solution {
    
    private List<List<Integer>> res  = new ArrayList<>();
    private List<List<Integer>> temp = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        if(nums == null) return res;
        
        res.add(new ArrayList<>()); // empty combination
        
        quicksort(nums, 0, nums.length - 1);
        
        for(int i = 1 ; i < nums.length + 1 ; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            getSubCombinations(temp, i, -1, nums, new ArrayList<>());
            res.addAll(temp);
        }
        
        return res;
    }
    
    public void getSubCombinations(List<List<Integer>> temp, int n, int curMaxIndex, int[] nums, ArrayList<Integer> curList) {
        
        if( n == 1 ) {
            for(int i = curMaxIndex + 1 ; i < nums.length ; i++) {
                curList.add( nums[i] );
                
                boolean hasExisted = false;
                for(int j = 0; j < temp.size() ; j++) {
                    List<Integer> list = temp.get(j);
                    int h = 0;
                    for( ; h < list.size() ; h++) {
                        if( list.get(h) != curList.get(h) ) break;
                    }
                    if(h == list.size() ) hasExisted = true;
                }
                /*for(int j = 0 ; j < preCombination.length ; j++) {
                    int val = curList.get(j);
                    if( preCombination[j] != val )  {
                        hasExisted = false;
                    }
                    preCombination[j] = val;
                }*/
                
                if(!hasExisted) {
                    ArrayList newList = new ArrayList<>();
                    newList.addAll(curList);
                    temp.add(newList);                    
                }
                curList.remove( curList.size() - 1 );
            }
        } else {
            for(int i = curMaxIndex + 1 ; i < nums.length ; i++) {
                curList.add( nums[i] );
                getSubCombinations(temp, n - 1, i, nums, curList);
                curList.remove( curList.size() - 1 );
            }
        }
    }
    
    public void quicksort(int[] nums, int left, int right) {
        int i = left, j = right, pivot = nums[ (left + right)/2 ];
        while(i <= j) {
            while(pivot > nums[i] ) i++;
            while(pivot < nums[j] ) j--;
            if( i <= j) {
                int temp = nums[i];
                nums[i]  = nums[j];
                nums[j]  = temp;
                i++;
                j--;
            }
        }
        if(left < j) quicksort(nums, left, j);
        if(i < right) quicksort(nums, i, right);
    }
}
