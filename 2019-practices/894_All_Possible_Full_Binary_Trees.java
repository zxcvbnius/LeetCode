/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public HashMap<Integer, List<TreeNode>> cache = new HashMap<>();
    
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if(N == 1) {
            res.add( new TreeNode(0) );
            return res;
        } else if ( N % 2 == 0) {
            return res;
        }
        
        if( cache.containsKey(N) ) return cache.get(N);
        
        for(int i = 1 ; i <= N - 1 ; i+=2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT( N -1 - i);
            for(int j = 0 ; j < left.size() ; j++) {
                for(int k = 0 ; k < right.size() ; k++) {
                    TreeNode root = new TreeNode(0);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    res.add( root );
                }    
            }
        }
        
        cache.put(N, res);
        
        return res;
    }
}
