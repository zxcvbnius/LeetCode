class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for(int n : nums) list.add( (double) n );
        return dfs( list );
    }
    
    public boolean dfs(List<Double> nums) {
        if( nums.size() == 1 ) {
            if( Math.abs( nums.get(0) - 24 ) < 0.001 ) {
                return true;
            }
            return false;
        }
        
        int len = nums.size();
        for(int i = 0 ; i < len ; i++) {

            for(int j = i + 1 ; j < len ; j++) {
                List<Double> possibles = getAllPossibles( nums.get(i), nums.get(j) );
                
                List<Double> remaining = new ArrayList<>();
                for(int k = 0 ; k < len ; k++) {
                    if( k == i || k == j  ) continue;
                    remaining.add( nums.get(k) );
                }
                
                for(double p: possibles) {
                    remaining.add(p);
                    if( dfs(remaining) ) return true;
                    remaining.remove(p);
                }
            }
        }
        return false;
    }
    
    public List<Double> getAllPossibles(double a, double b) {
        List<Double> list = new ArrayList<>();
        list.add( a * b );
        list.add( a / b );
        list.add( b / a );
        list.add( a - b );
        list.add( b - a );
        list.add( a + b );
        return list;
    }
}
