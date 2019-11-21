class Solution {
    public double minAreaFreeRect(int[][] points) {
        Set<String> set = new HashSet<>();
        
        double minArea = Integer.MAX_VALUE;
        
        for( int[] p : points ) set.add( p[0] + "_" + p[1] );
        
        for( int[] p1 : points ) {
            for( int[] p2 : points ) {
                if( p1[0] == p2[0] && p1[1] == p2[1] ) continue; // same point
                
                for( int[] p3 : points ) {
                    if( getDist(p1, p2) != getDist(p1, p3) + getDist(p2, p3) ) continue; // not rectangle
                    
                    int x = p1[0] + p2[0] - p3[0];
                    int y = p1[1] + p2[1] - p3[1];
                    
                    if( !set.contains(x + "_" + y) ) continue;
                    
                    double area = Math.sqrt( getDist(p1, p3) ) * Math.sqrt( getDist(p2, p3) );
                    if( area == 0 ) continue;
                    
                    minArea = Math.min( minArea, area );
                }
            }
        }
        
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
    
    public int getDist(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
