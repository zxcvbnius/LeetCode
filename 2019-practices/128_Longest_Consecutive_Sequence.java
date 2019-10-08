class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);

        int max = 1;
        for(int n : nums) {
            if( set.contains(n) ) { // not visisted
                int count = 1, val = n;
                while( set.contains(val - 1) ) {
                    set.remove( val - 1);
                    val--;
                    count++;
                }

                val = n;
                while( set.contains(val + 1) ) {
                    set.remove( val + 1);
                    val++;
                    count++;
                }
                max = Math.max( max, count);
            }
        }
        return max;
    }
}
