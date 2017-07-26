/**
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * For example:
 *   2, [[1,0]]
 *   There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 *   2, [[1,0],[0,1]]
 *   There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * 
 * Result. "Your runtime beats 69.88% of java submissions."
 */
 
 
 // Sol(2): Accepted
 public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0)
            return false;
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][1]]++;
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (x == prerequisites[i][0]) {
                    inDegree[prerequisites[i][1]]--;
                    if (inDegree[prerequisites[i][1]] == 0)
                        queue.offer(prerequisites[i][1]);
                }
            }
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] != 0)
                return false;
        }
        return true;
        
    }
}
 
//Sol(1): Time Limit Exceeded 
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if( prerequisites == null || numCourses == 0 || prerequisites.length == 0) return true;
        
        // Covert prerequisites into LinkedList, index : label, value: requisites
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>( numCourses);
        for(int i = 0 ; i < numCourses ; i++) lists.add( new ArrayList<>() );
        
        for(int i = 0 ; i < prerequisites.length ; i++) {
            int label = prerequisites[i][0];
            int prev  = prerequisites[i][1];
            ArrayList<Integer> list = lists.get(label);
            list.add(prev);
        }
        
        // If no prerequisites, the length of the list is zero
        boolean hasConflict = false;
        for(int i = 0 ; i < lists.size() ; i++) {
            if( isCircle(lists, lists.get(i), i, 0) ) {
                hasConflict = true;
                break;
            }
        }
        return !hasConflict;
        
    }
    public boolean isCircle(ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> curList, int originalLabel, int curLoop) {
        // System.out.println( "originalLabel : " + originalLabel);
        // System.out.println( "size of list : " + curList.size());
        if( curLoop > lists.size() ) return true;
        else if( curList.size() == 0) return false;
        else if( curList.indexOf( originalLabel ) >= 0 ) return true;
        else {
            for(Integer val : curList) {
                if( isCircle( lists, lists.get(val), originalLabel, curLoop + 1) ) {
                    return true;
                }
            }
            return false;
        }
    }
}
