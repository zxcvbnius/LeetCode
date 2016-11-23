/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * 
 */
 
 // So1, Using recursive to check the current p and q step by step
 // Result. "Your runtime beats 18.77% of java submissions." but this is the best solution.
 public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if( p == null && q == null) return true;
      if( p == null || q == null) return false;
      
      return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
 
 
 // Sol2, Using Pre-Order and In-Order to check if p and q are the same tree
 // Result. "Your runtime beats 1.57% of java submissions." :(
 public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if( p == null && q == null) return true;
      else if( p == null || q == null) return false;
      
      // run pre-order and in-order
      ArrayList<Integer> pre1 = preOrder(new ArrayList<>(), p);
      ArrayList<Integer> in1  = inOrder(new ArrayList<>(), p);
      
      ArrayList<Integer> pre2 = preOrder(new ArrayList<>(), q);
      ArrayList<Integer> in2  = inOrder(new ArrayList<>(), q);
      
      if(pre1.size() != pre2.size() || in1.size() != in2.size()) return false;
      // check pre-order
      {
          int size = pre1.size();
          for(int i = 0 ; i < size ; i++) {
              if(pre1.get(i) == null) {
                  if(pre2.get(i) != null) return false;
              } else {
                  if(pre2.get(i) == null) return false;
                  if( pre1.get(i) - pre2.get(i) != 0 ) return false;
              }
          }
            
      } {
          int size = in1.size();
          for(int i = 0 ; i < size ; i++) {
              if(in1.get(i) == null) {
                  if(in2.get(i) != null) return false;
              } else {
                  if(in2.get(i) == null) return false;
                  if( in1.get(i) - in2.get(i) != 0 ) return false;
              }
          }
      }
      return true;
    }
    
    public ArrayList<Integer> preOrder(ArrayList<Integer> list, TreeNode node) {
        if(node == null) {list.add(null); return list;}
        list.add(node.val);
        preOrder(list, node.left);
        preOrder(list, node.right);
        return list;
    }
    
    public ArrayList<Integer> inOrder(ArrayList<Integer> list, TreeNode node) {
        if(node == null) {list.add(null); return list;}
        preOrder(list, node.left);
        list.add(node.val);
        preOrder(list, node.right);
        return list;
    }
}
