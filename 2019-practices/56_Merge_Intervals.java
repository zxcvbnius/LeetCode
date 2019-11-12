class Solution {

    class Node {
       int start;
       int end;
       public Node(int start, int end) {
           this.start = start;
           this.end = end;
       }
    }

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        int[] start = new int[ len ];
        int[] end = new int[ len ];

        for(int i = 0 ; i < len ; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        List<Node> list = new ArrayList<>();
        Node prev = null;

        for(int i = 0 ; i < len ; i++) {
            if( prev == null || (start[i] > prev.end) ) {
                Node n = new Node( start[i], end[i] );
                list.add(n);
                prev = n;
            } else if ( prev.end < end[i] ) {
                prev.end = end[i];
            }
        }

        int[][] ans = new int[ list.size()  ][2];
        for(int i = 0 ; i < ans.length ; i++) {
            ans[i][0] = list.get(i).start;
            ans[i][1] = list.get(i).end;
        }

        return ans;
    }
}
