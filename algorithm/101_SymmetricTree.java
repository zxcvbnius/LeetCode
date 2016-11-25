/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *    
 */
 
 // Compare each node
 // Result. "Your runtime beats 22.99% of java submissions." (Most ppl in the range)
 public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSame(root.left, root.right);
    }
    
    public boolean isSame(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val == node2.val) {
            return isSame(node1.left, node2.right) && isSame(node1.right, node2.left);
        }
        return false;
    }
}

 
 // Using Level Order, very very slow
 // Result. "Your runtime beats 2.23% of java submissions. :("
 public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        ArrayList<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        
        while(true) {
            temp = getChildren(temp);
            
            int size = temp.size();
            int nullCount = 0;
            
            for(int i = 0 ; i < size / 2 ; i++ ) {
                TreeNode node1 = temp.get(i);
                TreeNode node2 = temp.get( size - i - 1);
                if(node1 == null && node2 == null) {nullCount += 2; continue;}
                if(node1 == null || node2 == null) return false;
                if(node1.val != node2.val) {
                    return false;
                }
            }
            if(nullCount == size) break;
        }
        return true;
    }
    
    public ArrayList<TreeNode> getChildren(ArrayList<TreeNode> parents) {
        ArrayList<TreeNode> list = new ArrayList<>();
        for(TreeNode p : parents) {
            if(p != null) {
                list.add(p.left);
                list.add(p.right);                
            }
        }
        return list;
    }
}
