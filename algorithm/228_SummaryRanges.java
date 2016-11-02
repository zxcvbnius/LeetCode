/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * Result. "Your runtime beats 56.54% of java submissions :("
 */
 
 public class Solution {
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        List<String> res = new ArrayList<String>();
        if(len == 0) {
            // do nothing
        }
        else if(len == 1) {
            res.add( String.valueOf(nums[0]) );
        } else {
            int start   = nums[0];
            int count   = 0; 
            for(int i = 1 ; i < len ; i++) {
                if(nums[i] - nums[i-1] != 1) {
                    String range = (count == 0) ? String.valueOf(start) : String.valueOf(start) + "->" + String.valueOf(nums[i-1]);
                    res.add(range);
                    start = nums[i];
                    count = 0;
                } else {
                    count++;
                }
            }
            String range = (count == 0) ? String.valueOf(start) : String.valueOf(start) + "->" + String.valueOf(nums[len-1]);
            res.add(range);
        }
        return res;
    }
}
