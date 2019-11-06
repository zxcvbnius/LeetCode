class Solution {
    public int minAreaRect(int[][] points) {

        int min = Integer.MAX_VALUE;
 
       HashMap<Integer, Set<Integer>> map = new HashMap<>();
       for(int[] point : points) {
           int x = point[0], y = point[1];
           if( !map.containsKey( x ) ) map.put( x, new HashSet<Integer>() );
           map.get( x ).add( y );
       }

       for(int i = 0 ; i < points.length ; i++) {
           for(int j = i + 1 ; j < points.length ; j++) {
               if( points[i][0] == points[j][0] || points[i][1] == points[j][1] ) continue;

               boolean res1 = map.containsKey( points[i][0] ) && map.get( points[i][0] ).contains( points[j][1] );
               boolean res2 = map.containsKey( points[j][0] ) && map.get( points[j][0] ).contains( points[i][1] );

               if( res1 && res2 ) {
                  min = Math.min( Math.abs( points[i][0] - points[j][0] ) * Math.abs( points[i][1] - points[j][1] ), min );
               }
           }
       }

       return min == Integer.MAX_VALUE ? 0 : min; 

    }
}
