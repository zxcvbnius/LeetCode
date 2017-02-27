/**
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
 * 
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * All root-to-leaf paths are:
 * 
 * ["1->2->5", "1->3"]
 *  
 */
// Should avioid not to use 'String.valueOf()'
// Result. "Your runtime beats 60% of java submissions"
public class Solution {
    
    private ArrayList<String> results = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return results;
        findPath(root, new ArrayList<>());
        return results;
    }
    public void findPath(TreeNode currentNode, List<TreeNode> currentList) {
        if(currentNode.left == null && currentNode.right == null ) {
            StringBuilder builder = new StringBuilder();
            for(TreeNode n : currentList) {
                builder.append( n.val );
                builder.append("->");
            }
            builder.append( currentNode.val );
            results.add( builder.toString() );
        }
        
        if(currentNode.left != null) {
            currentList.add(currentNode);
            findPath(currentNode.left, currentList);
            currentList.remove(currentNode);
        }
        
        if(currentNode.right != null) {
            currentList.add(currentNode);
            findPath(currentNode.right, currentList);
            currentList.remove(currentNode);
        }
    }
}




// Result. "Your runtime beats 23% of java submissions"
public class Solution {
    
    private ArrayList<String> results = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return results;
        findPath(root, new ArrayList<>());
        return results;
    }
    public void findPath(TreeNode currentNode, List<TreeNode> currentList) {
        if(currentNode.left == null && currentNode.right == null ) {
            StringBuilder builder = new StringBuilder();
            for(TreeNode n : currentList) {
                builder.append( String.valueOf(n.val) );
                builder.append("->");
            }
            builder.append( String.valueOf(currentNode.val) );
            results.add( builder.toString() );
        }
        
        if(currentNode.left != null) {
            currentList.add(currentNode);
            findPath(currentNode.left, currentList);
            currentList.remove(currentNode);
        }
        
        if(currentNode.right != null) {
            currentList.add(currentNode);
            findPath(currentNode.right, currentList);
            currentList.remove(currentNode);
        }
    }
}
