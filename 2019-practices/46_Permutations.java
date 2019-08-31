class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        int len = nums.length;
        dfs( nums, res, new ArrayList<Integer>());
        return res;
    }
    
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur) {
        int len = nums.length;
    
        if( cur.size() == len ) {
            ArrayList<Integer> list = new ArrayList<>(cur);
            res.add( list );
            return;
        }
        
        for(int i = 0; i < len ; i++ ) {
            int val = nums[ i ];
            if( cur.contains(val) ) continue;
            cur.add( val );
            dfs(nums, res, cur);
            cur.remove( cur.size() - 1);
        }
    }
}
