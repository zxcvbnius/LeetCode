/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * 
 * Result. "Your runtime beats 41.83% of java submissions."
 */
 public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
        int area1 = Math.abs((A-C)*(B-D));
        int area2 = Math.abs((E-G)*(F-H));
        
        int overlap = 0; 
        
        if( (G < A) || (C < E) ) return area1 + area2;
        else {
            if( (H < B)  || (D < F) ) return area1 + area2;
            
            int leftX = Math.max(A, E);
            int rightX = Math.min(C, G);
            int topY = Math.min(D, H);
            int bottomY = Math.max(B, F);
            
            overlap = Math.abs( (rightX - leftX)*(topY - bottomY) );
            
        }
        
        return area1 + area2 - overlap;
        
    }
}
