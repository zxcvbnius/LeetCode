/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * 
 * For example:
 * 
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Result. "Your runtime beats 11.89% of java submissions."
 */
 public class Solution {
    public int[] singleNumber(int[] nums) {

        Set<Integer> result = new HashSet<>();
        Set<Integer> masks  = new HashSet<>();
        for(int num : nums) {
            if(masks.contains(num)) { // more than once
                result.remove(num);
                continue;
            }
            result.add(num);
            masks.add(num);
        }
        int[] aws = new int[result.size()];
        int index = 0;
        for(Integer v : result) { 
            aws[index++] = v;
        }
        return aws;
    }
}
