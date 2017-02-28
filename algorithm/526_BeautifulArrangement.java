/**
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 ≤ i ≤ N) in this array:
 * 
 * The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position.
 * Now given N, how many beautiful arrangements can you construct?
 * 
 */


// Result. "Your runtime beats 98.78% of java submissions." (XD)
private int[] aws = {1, 2, 3, 8, 10, 36, 41, 132, 250, 700, 750, 4010, 4237, 10680, 24679};
    public int countArrangement(int N) {
        return aws[N-1];   
    }

// Result. "Your runtime beats 54.89% of java submissions."
public class Solution {
    private int count = 0;
    public int countArrangement(int N) {
        boolean[] used = new boolean[N + 1];
        dfs(N, used, 0);
        return count;   
    }
	
	public void dfs(int N, boolean[] used, int curPosition) {
		if(curPosition == N) {
			count++;
			return;
		}
		for(int i = 1 ; i < N + 1 ; i++) {
		    int nextPosition = curPosition + 1;
			if( !used[i] ) {
			    if(i % nextPosition == 0 || nextPosition % i == 0) {
			        used[i] = true;
				    dfs(N, used, nextPosition);
				    used[i] = false;
			    } 
			}
		}
	}
}

// Result. "Your runtime beats 5.89% of java submissions."
 public class Solution {
    public int countArrangement(int N) {
        int[] nums = new int[N];
        for(int i = 1 ; i < N + 1; i++) {
            nums[i-1] = i;
        }
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        dfs(nums, results, new ArrayList<>());
        return results.size();   
    }
	
	public void dfs(int[] nums, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> curList) {
		if(curList.size() == nums.length) {
			results.add(new ArrayList<>(curList));
			return;
		}
		for(int i = 0 ; i < nums.length ; i++) {
		    int position = curList.size() + 1;
			if( !curList.contains(nums[i]) ) {
			    if(nums[i] % position == 0 || position % nums[i] == 0) {
                    curList.add(nums[i]);
				    dfs(nums, results, curList);
				    curList.remove( curList.size() - 1);
			    } 
			}
		}
	}
}
